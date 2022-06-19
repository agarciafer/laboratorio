job('ejemplo-job-DSL-desde-GitHub') {
  description('Job DSL de ejemplo para el curso de Jenkins')
  scm {
    git('https://github.com/agarciafer/laboratorio.git', 'master') { node ->
      node / gitConfigName('agarciaf')
      node / gitConfigEmail('agarciaf@outlook.es')
    }
  }
  
  parameters {
    stringParam('nombre', defaultValue = 'operador', description = 'Parametro de cadena para el Job Booleano')
    choiceParam('planeta', ['Mercurio', 'Venus', 'Tierrra', 'Marte', 'Jupiter', 'Saturno', 'Urano', 'Neptuno'])
    booleanParam('agente', false)
  }
  
  triggers {
    cron('H/7 * * * *')
  }
  steps {
    shell("bash job-scritp.sh")
  }
  
  }
