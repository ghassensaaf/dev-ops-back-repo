pipeline {
    agent any
  
    stages {
        stage("init git") {
            steps {
              echo 'initializing the app...'
               echo 'Pulling from Git ...';
              git branch : 'nadhir',
              url : 'https://github.com/ghassensaaf/dev-ops-back-repo.git';

            }
        }
        stage("Maven build") {
            steps {
             sh "mvn clean install"
            }
        }
        stage("sonarqube") {
            
            
            steps {
             sh "chmod +x sonar.sh"  
             sh "./sonar.sh"
            }
        }
        stage ('MVN Deploy nexus') {
            steps {
            echo "Maven deploy nexus";
                sh 'mvn clean deploy -DskipTests -Dmaven.install.skip=true';
            }
        }
        stage("deploy") {
            steps {
               echo 'deploying the app...'
            }
        }
    }   
}
