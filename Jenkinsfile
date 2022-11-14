pipeline {
  agent any

  stages {
    stage('Pull Git') {
      steps {
        echo 'Pulling ... ';
        git branch: 'emna', credentialsId: 'github', url: 'https://github.com/ghassensaaf/dev-ops-back-repo.git';
      }
    }
	  

		  	  stage('MVN Clean') {
      steps {
        sh 'mvn clean';
      }
    }
	  
         stage ('MVN compile')
        {
         steps{
                sh 'mvn compile'
            }
        }
	  
         stage ('build package')
        {
         steps{
                sh 'mvn clean package'
            }
        }
	 stage('SonarQube + JacOcO Analysis') {
			steps {
				sh "mvn  sonar:sonar -Dsonar.projectKey=devops  -Dsonar.host.url=http://192.168.33.10:9000  -Dsonar.login=9c54388b097c42413bd59a7fea79f45388282879"
			}
		        post {
				always {
					jacoco execPattern: 'target/jacoco.exec'
				       }    
			    } 
		 }  
	  
	//   stage('Nexus') {
	//		steps {
				//sh 'mvn clean deploy -DskipTests'
	//			sh 'mvn clean deploy -Dmaven.test.skip=true -Dresume=false'
	//		}
	//	} 
	  
	  
	  
	   stage ('Nexus') {
            steps {
            echo "Nexus";
                sh 'mvn clean deploy -DskipTests -Dmaven.install.skip=true';
            }
        }	  
  }
    }
	 /*   
           stage('DOCKER Compose') {
             steps {
             echo 'docker compose stage';
                 sh 'docker-compose up -d'
      }
    }

	

    
    stage('MVN TEST') {
      steps {
        sh 'mvn test ';
      }
    }

  

    stage('MVN DEPLOY') {
      steps {
        sh 'mvn clean deploy -Dmaven.test.skip=true';
      }
    }

  
	    
	  stage('DOCKER Compose') {
      steps {
        echo 'docker compose stage';
        sh 'docker-compose up -d'
      }
    }
	



   /*stage('Build Artifact - Maven') {
			steps {
				sh "mvn clean package -DskipTests=true"
				archive 'target/*.jar'
			      }
		}
	
 */
	  
	
