package storm.sacla_starter.topology

import backtype.storm.Config
import backtype.storm.LocalCluster
import backtype.storm.StormSubmitter
import backtype.storm.task.OutputCollector
import backtype.storm.task.TopologyContext
import backtype.storm.testing.TestWordSpout
import backtype.storm.topology.OutputFieldsDeclarer
import backtype.storm.topology.TopologyBuilder
import backtype.storm.topology.base.BaseRichBolt
import backtype.storm.tuple.Fields
import backtype.storm.tuple.Tuple
import backtype.storm.tuple.Values
import backtype.storm.utils.Utils

class ExclamationBolt extends BaseRichBolt{

    var _collector: OutputCollector = _


    override def prepare(conf: java.util.Map[_, _], context: TopologyContext, collector: OutputCollector) {
        _collector = collector
    }
        


    override def execute(tuple: Tuple) {
        _collector.emit(tuple, new Values(tuple.getString(0) + "+"))
        _collector.ack(tuple)
    }  
    
    override def declareOutputFields(declarer: OutputFieldsDeclarer) = 
      declarer.declare(new Fields("word"))

}

object ExclamationTology {

    def main(args: Array[String]){
        val builder = new TopologyBuilder

        builder.setSpout("word", new TestWordSpout(), 10)
        builder.setBolt("exclaim1",new ExclamationBolt(), 3).shuffleGrouping("word")
        builder.setBolt("exclaim2", new ExclamationBolt(), 2).shuffleGrouping("exclaim1")

        val conf = new Config()
        conf.setDebug(true)

        val cluster = new LocalCluster()
        cluster.submitTopology("testEx1", conf, builder.createTopology())
        Utils.sleep(10000)
        cluster.killTopology("testEx1")
        cluster.shutdown()
    }
}