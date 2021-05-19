
pipeline {

  
   agent  any
        
    stages {
        stage('checkout') {
            steps {
                 script{
                        dir("new_terraform")
                        {
                            git "https://github.com/Anupriya35/terra_code.git"

                        }
                    }
                }
            }
stage('Plan') {
            steps {
                sh 'pwd;cd TERRAFORM/terra_code; terraform init -input=false'
                
		            }
        }

       
        }
  
  }
