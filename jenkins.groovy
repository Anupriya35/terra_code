
pipeline {

  
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
stage('Plan') {
            steps {
                sh 'pwd;cd terraform; terraform init -input=false'
                
		            }
        }

       
        }
  
  }
