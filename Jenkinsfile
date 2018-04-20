node (){

    stage ('Checkout'){
    try {
       checkout scm
        mvnHome = tool 'M3'


    }catch(err) {
        notify("Error ${err}")
        currentBuild.result = 'FAILURE'
    }
}

stage('Build') {
      // Run the maven build

      try {

        sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"

      } catch(err) {
        notify("Error ${err}")
        currentBuild.result = 'FAILURE'
    }

}

stage ('Archive test and artifact to s3 bucket') {
        step([$class: 'JUnitResultArchiver',
              testResults: 'target/surefire-reports/TEST-*.xml'])

                  //with AWS store creds and region to target
           withAWS(credentials: 'jenkinsAWSApi', region: 'us-east-1'){
                // s3uploads includePathPattern: * include all files in workingDir, bucket is the s3 bucket we target path is the path to eVision
                s3Upload(includePathPattern:'*', workingDir:'target' , bucket:'logicode-artifacts', path: 'eVision/')
            }

         stash includes: '**', name: 'archive'
}
