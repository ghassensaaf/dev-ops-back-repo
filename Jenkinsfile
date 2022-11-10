pipeline {
    agent any



    stages {
        stage('Git') {
            steps {

                git branch: 'main', url: 'https://github.com/ghassensaaf/dev-ops-back-repo.git',

            }


        }
        stage('MVN Package'){
            steps {
                sh """mvn -version  """
                sh """java -version """
                sh """mvn package -e """
            }
        }

        stage("MVN Clean"){
            steps {
                sh """mvn clean -e """

            }
        }

         stage("MVN Compile"){
            steps {
                sh """mvn compile -e """

            }
        }

        stage("MVN Install"){
            steps {
                sh """mvn install """

            }
        }



    }
}