
pipeline {
	
parameters {
        string(name: 'environment', defaultValue: 'terraform', description: 'Workspace/environment file to use for deployment')
        booleanParam(name: 'autoApprove', defaultValue: false, description: 'Automatically run apply after generating plan?')

    }
  
   agent  any
        
    stages {
        stage('checkout') {
            steps {
                 script{
                        dir("terraform")
                        {
                            git "https://github.com/Anupriya35/terra_code.git"
 			  
                        }
                    }
                }
            }
stage('terraform init') {
            steps {
                sh 'pwd;cd terraform; terraform init -input=false'
                
		            }
        }
stage('terraform Plan') {
            steps {
               
                sh 'pwd;cd terraform ; terraform workspace new ${environment}'
                sh 'pwd;cd terraform ; terraform workspace select ${environment}'
                sh "pwd;cd terraform ;terraform plan -input=false -out tfplan "
                sh 'pwd;cd terraform ;terraform show -no-color tfplan > tfplan.txt'
            }
        }
       
        }
  
  }
