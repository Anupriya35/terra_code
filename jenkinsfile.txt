
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

        }
  }
