pipeline {
    agent any



    stages {
        stage('Git') {
            steps {

                git branch: 'ons', url: 'https://github.com/ghassensaaf/dev-ops-back-repo.git',
                credentialsId : '33c04f0b-acb3-488e-80de-00a29b1c504f'

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