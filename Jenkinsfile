pipeline {
    agent any
  
    stages {
        
            
        
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
        stage("docker build image") {
            steps {
                
              docker build -t hiados10/devops:1.0.0
               
            }
        }
    }   
}
