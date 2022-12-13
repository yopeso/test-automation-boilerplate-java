variable "aws_access_token" {
  description = "AWS access key"
  type        = string
  default     = ""
}

variable "aws_secret_key" {
  description = "AWS secret key"
  type        = string
  default     = ""
}

# Defining Region
variable "aws_region" {
  default = "eu-central-1"
}

# Defining CIDR Block for VPC
variable "vpc_cidr" {
  default = "10.123.0.0/16"
}
