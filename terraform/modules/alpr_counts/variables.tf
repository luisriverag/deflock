variable "module_name" {
  description = "Name of the module"
}

variable "output_filename" {
  description = "Filename for the ALPR counts JSON file"
  default     = "alpr-counts.json"
}

variable "deflock_stats_bucket" {
  description = "S3 bucket for the ALPR counts JSON file"
}

variable "rate" {
  description = "Rate at which to run the Lambda function"
}

variable "aws_region" {
  description = "The AWS region where resources will be created"
  type        = string
  default     = "us-east-1"
}

variable "aws_account_id" {
  description = "The AWS account ID where resources will be created"
  type        = string
  default     = "912821578123"
}

variable "sns_topic_arn" {
  description = "The ARN of the SNS topic for Lambda alarms"
  type        = string
}
