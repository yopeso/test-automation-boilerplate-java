resource "aws_vpc" "hub_vpc" {
  cidr_block           = var.vpc_cidr
  enable_dns_hostnames = true
  enable_dns_support   = true

  tags = {
    Name = "Default Selenium HUB VPC"
  }
}

resource "aws_subnet" "hub_public_subnet" {
  vpc_id                  = aws_vpc.hub_vpc.id
  cidr_block              = "10.123.1.0/24"
  map_public_ip_on_launch = true
  availability_zone       = "eu-central-1a"

  tags = {
    Name = "Public HUB"
  }
}

resource "aws_internet_gateway" "hub_internet_gateway" {
  vpc_id = aws_vpc.hub_vpc.id

  tags = {
    Name = "HUB igw"
  }
}

resource "aws_route_table" "hub_public_rt" {
  vpc_id = aws_vpc.hub_vpc.id

  tags = {
    Name = "HUB Public route table"
  }
}

resource "aws_route" "default_route" {
  route_table_id         = aws_route_table.hub_public_rt.id
  destination_cidr_block = "0.0.0.0/0"
  gateway_id             = aws_internet_gateway.hub_internet_gateway.id
}

resource "aws_route_table_association" "hub_public_association" {
  subnet_id      = aws_subnet.hub_public_subnet.id
  route_table_id = aws_route_table.hub_public_rt.id
}

resource "aws_security_group" "hub_security_group" {
  name        = "selenium_hub_security_group"
  description = "Selenium Hub Security Group"
  vpc_id      = aws_vpc.hub_vpc.id

  ingress {
    from_port   = 4444
    to_port     = 4444
    protocol    = "TCP"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    protocol    = "TCP"
    from_port   = 22
    to_port     = 22
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 80
    to_port     = 80
    protocol    = "TCP"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_eip" "skynet_eip" {
  vpc = true
}

data "aws_eip" "skynet_eip" {
  public_ip = "18.198.145.32"
}

resource "aws_eip_association" "eip_assoc" {
  instance_id   = aws_instance.hub_node.id
  allocation_id = data.aws_eip.skynet_eip.id
}

resource "aws_instance" "hub_node" {
  instance_type = "t2.medium"
  ami           = "ami-01bcb21f02a5da66f" # Ubuntu 20.04 LTS // us-east-1

  vpc_security_group_ids = [aws_security_group.hub_security_group.id]
  subnet_id              = aws_subnet.hub_public_subnet.id

  user_data = data.template_file.user_data.rendered

  tags = {
    Name = "hub-node"
  }
}