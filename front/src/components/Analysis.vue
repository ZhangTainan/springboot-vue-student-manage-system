<template>
  <div class="data-view mt-3">
    <el-card>
        <div id="bar"></div>
    </el-card>
    <el-card>
        <div id="pie"></div>
    </el-card>
  </div>
</template>

<script>
import axios from 'axios'
export default {
    data() {
        return {
            avgScore: {},
            placeCount:[]
        }
    },
    computed: {
        avgScoreList() {
            return [this.avgScore.chi,this.avgScore.math,this.avgScore.eng]
        }
    },
   async mounted() {
       await axios({
            url: "http://localhost:8080/average_score",
            method: "GET",
        }).then(res => {
            this.avgScore = res.data
        })
        await axios({
            url: "http://localhost:8080/get_place_count",
            method: "GET",
        }).then(res => {
            this.placeCount = res.data
        })
        var myChart = this.$charts.init(document.getElementById("bar"))
        var myChart2 = this.$charts.init(document.getElementById("pie"))
        myChart.setOption({
            title: {
            text: '各科成绩平均分'
        },
        legend: {
                // Try 'horizontal'
                orient: 'vertical',
                right: 10,
                top: 'center'
            },
            
        dataset: {
            source: [
            ['name', '语文', '数学', '英语'],
            ['平均分', this.avgScoreList[0],this.avgScoreList[1],this.avgScoreList[2]],
            ]
        },
        xAxis: { type: 'category' },
        yAxis: {},
            series: [{ type: 'bar', name: "语文" }, { type: 'bar' }, { type: 'bar' }],
            tooltip: { // 鼠标悬浮提示框显示 X和Y 轴数据
                trigger: 'axis',
                backgroundColor: 'rgba(32, 33, 36,.7)',
                borderColor: 'rgba(32, 33, 36,0.20)',
                borderWidth: 1,
                textStyle: { // 文字提示样式
                    color: '#fff',
                    fontSize: '12'
                }
            }
        })
       myChart2.setOption({
           title: {
                text:"生源地分布情况图"
            },
  tooltip: {
    trigger: 'item'
  },
  legend: {
    top: '88%',
    left: 'center'
  },
  series: [
    {
      name: '学生人数',
      type: 'pie',
      radius: ['40%', '70%'],
      avoidLabelOverlap: false,
      itemStyle: {
        borderRadius: 10,
        borderColor: '#fff',
        borderWidth: 2
      },
      label: {
        show: false,
        position: 'center'
      },
      emphasis: {
        label: {
          show: true,
          fontSize: '40',
          fontWeight: 'bold'
        }
      },
      labelLine: {
        show: false
      },
      data:this.placeCount
    }
  ]
})
    },
}
</script>

<style>
    .data-view{
        width: 100%;
        display:flex;
        justify-content:space-between
    }
    #bar{
        width:450px;
        height:375px
    }
    #pie{
        width:480px;
        height:375px
    }
   
</style>