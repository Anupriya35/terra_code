
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
                        dir("terraform_checkout")
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

       
        }
  
  }
