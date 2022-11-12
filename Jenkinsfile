pipeline {
    agent any



    stages {
        stage('Git') {
            steps {
                git branch: 'ons', credentialsId: '28fae579-cf0e-4594-b0af-3e8732bd44c8', url: 'https://github.com/ghassensaaf/dev-ops-back-repo.git'
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
        stage('sonar'){
            steps {
                script{ withSonarQubeEnv('sonar') {
                     sh """mvn sonar:sonar -DskipTests"""
                 }

                }
            }
        }

        stage("Nexus"){
            steps {
            nexusArtifactUploader artifacts: [[artifactId: 'tpAchatProject', classifier: '', file: 'target/tpAchatProject-1.0.jar', type: 'jar']], credentialsId: 'nexus3', groupId: 'com.esprit.examen', nexusUrl: 'localhost:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'nuget-hosted', version: '1.0'
            }
        }
    }
}