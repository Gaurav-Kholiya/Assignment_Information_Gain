package com.hashmap

class Generator {

  def generateCandidate(series:List[Double],maxLength:Int):List[Candidate]={
      val label=series.last.toInt
      var candidates=List[Candidate]()
        for(i<-0 until series.length-maxLength){
          var candidate=List[Double]()
          for(j<-i until i+maxLength){
            candidate=candidate:+series(j)
          }
          candidates=candidates:+Candidate(candidate,label)
        }
      candidates
  }

  def getLabels(matrix:Array[Array[Double]]):List[Int]={
    val rows=matrix.length
    val cols=matrix(0).length
    var labels=List[Int]()
    for(i<-0 until rows){
      labels=labels:+matrix(i).last.toInt
    }
    labels
  }

  def calculateHighestEntropy(labels:List[Int]):Double={
    var entropy=0.0
    val sum: Double =labels.sum
    for(i<-labels.indices){
      val p=labels(i)/sum
      entropy= entropy- p *scala.math.log(p)
    }
    entropy
  }

}
