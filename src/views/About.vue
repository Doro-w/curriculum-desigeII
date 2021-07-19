<template>
  <div>
    <el-row :gutter="20" style="margin-bottom: 50px" >
      <el-col :span="8">
        <el-card>
          <div id="chart_pie1" :style="{width: '500px', height: '700px'}"></div>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card>
          <div id="chart_pie2" :style="{width: '500px', height: '700px'}"></div>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card>
          <div id="chart_pie3" :style="{width: '500px', height: '700px'}"></div>
        </el-card>
      </el-col>
    </el-row>
  </div>

</template>
<script>
export default {
  name: 'levelModule',
  data() {
    return {
      //环形图数据
      CirCleChart1Data: {
        W11: '',
        W12: '',
        W13: '',
      },
      CirCleChart2Data: {
        W21: '',
        W22: '',
        W23: '',
        W24: '',
        W25: '',
      },
      CirCleChart3Data: {
        W31: '',
        W32: '',
        W33: '',
      },
    }
  },
  created() {
    this.getWeight();
  },
  mounted() {
    this.showChart();
  },
  methods: {
    showChart() {
      // 基于准备好的dom，初始化echarts实例，通过id获取div窗体，封装成myChart对象
      let myChart1 = document.getElementById('chart_pie1');
      let myChart2 = document.getElementById('chart_pie2');
      let myChart3 = document.getElementById('chart_pie3');

      myChart1.style.width = window.innerWidth/2*0.5+ 'px';
      myChart1.style.height = window.innerHeight/2*0.7+ 'px';
      myChart2.style.width = window.innerWidth/2*0.5+ 'px';
      myChart2.style.height = window.innerHeight/2*0.7+ 'px';
      myChart3.style.width = window.innerWidth/2*0.5+ 'px';
      myChart3.style.height = window.innerHeight/2*0.7+ 'px';
    },
    async getWeight() {
      let that = this;
      await that.$http.get('/module/level').then(function (response) {
        that.CirCleChart1Data.W11 = response.data[0]['w1'][0];
        that.CirCleChart1Data.W12 = response.data[0]['w1'][1];
        that.CirCleChart1Data.W13 = response.data[0]['w1'][2];
        that.CirCleChart2Data.W21 = response.data[0]['w2'][0];
        that.CirCleChart2Data.W22 = response.data[0]['w2'][1];
        that.CirCleChart2Data.W23 = response.data[0]['w2'][2];
        that.CirCleChart2Data.W24 = response.data[0]['w2'][3];
        that.CirCleChart2Data.W25 = response.data[0]['w2'][4];
        that.CirCleChart3Data.W31 = response.data[0]['w3'][0];
        that.CirCleChart3Data.W32 = response.data[0]['w3'][1];
        that.CirCleChart3Data.W33 = response.data[0]['w3'][2];
        that.chart_pie1()
        that.chart_pie2()
        that.chart_pie3()
      }).catch(function (error) {
        console.log(error)
      })
    },
    chart_pie1(){
      let myChart = this.$echarts.init(document.getElementById("chart_pie1"))

      const option = {
        title: {
          text: 'W1',
          left: 'left'
        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          orient: 'vertical',
          x: '80%',
          y: 'center'
        },
        series: [
          {
            name: '详情',
            type: 'pie',
            radius: ['20%', '40%'],
            itemStyle: {},
            data: [
              {
                value: this.CirCleChart1Data.W11,
                name: 'w11'
              },
              {
                value: this.CirCleChart1Data.W12,
                name: 'w12'
              },
              {
                value: this.CirCleChart1Data.W13,
                name: 'w13'
              }
            ],
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      };
      myChart.setOption(option)
    },
    chart_pie2(){
      let myChart = this.$echarts.init(document.getElementById("chart_pie2"))

      const option = {
        title: {
          text: 'W2',
          left: 'left'
        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          orient: 'vertical',
          x: '80%',
          y: 'center'
        },
        series: [
          {
            name: '详情',
            type: 'pie',
            radius: ['20%', '40%'],
            itemStyle: {},
            data: [
              {
                value: this.CirCleChart2Data.W21,
                name: 'w21'
              },
              {
                value: this.CirCleChart2Data.W22,
                name: 'w22'
              },
              {
                value: this.CirCleChart2Data.W23,
                name: 'w23'
              },
              {
                value: this.CirCleChart2Data.W24,
                name: 'w24'
              },
              {
                value: this.CirCleChart2Data.W25,
                name: 'w25'
              }
            ],
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      };
      myChart.setOption(option)
    },
    chart_pie3(){
      let myChart = this.$echarts.init(document.getElementById("chart_pie3"))

      const option = {
        title: {
          text: 'W3',
          left: 'left'
        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          orient: 'vertical',
          x: '80%',
          y: 'center'
        },
        series: [
          {
            name: '详情',
            type: 'pie',
            radius: ['20%', '40%'],
            itemStyle: {},
            data: [
              {
                value: this.CirCleChart3Data.W31,
                name: 'w31'
              },
              {
                value: this.CirCleChart3Data.W32,
                name: 'w32'
              },
              {
                value: this.CirCleChart3Data.W33,
                name: 'w33'
              }
            ],
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      };
      myChart.setOption(option)
    }
  }
}

</script>
<style scoped>

</style>
