data "template_file" "user_data" {
  template = file("start_selenium_hub.sh")
}
