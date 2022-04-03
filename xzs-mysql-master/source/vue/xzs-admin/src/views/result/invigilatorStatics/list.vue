<template>
  <div class="line1">
    <div class="part1">
      <div id="main01" style="width: 600px; height: 400px"></div>
    </div>
    <div class="part2">
      <div id="main02" style="width: 600px; height: 400px"></div>
    </div>
  </div>
</template>

<script>
import * as echarts from "echarts";
export default {
  name: "list",
  mounted() {
    var myChart01 = echarts.init(document.getElementById("main01"));
    // 绘制图表
    myChart01.setOption({
      title: {
        text: "题型完成所需时间",
      },
      tooltip: {},
      xAxis: {
        data: ["选择题", "填空题", "第一部分", "第二部分", "附加题"],
      },
      yAxis: {},
      series: [
        {
          name: "时间",
          type: "bar",
          data: [15, 30, 30, 35, 10],
        },
      ],
    });

    var myChart02 = echarts.init(document.getElementById("main02"));
    myChart02.setOption({
      title: {
        text: "我的能力",
      },
      legend: {
        data: ["平均能力", "我的能力"],
      },
      radar: {
        // shape: 'circle',
        indicator: [
          { name: "语文", max: 100 },
          { name: "数学", max: 100 },
          { name: "英语", max: 100 },
          { name: "政治", max: 100 },
          { name: "历史", max: 100 },
          { name: "地理", max: 100 },
          { name: "物理", max: 100 },
          { name: "化学", max: 100 },
          { name: "生物", max: 100 },
          { name: "技术", max: 100 },
        ],
      },
      series: [
        {
          name: "Budget vs spending",
          type: "radar",
          data: [
            {
              value: [85, 75, 90, 80, 80, 80, 80, 80, 80, 80],
              name: "平均能力",
            },
            {
              value: [80, 100, 85, 70, 70, 75, 95, 90, 90, 97],
              name: "我的能力",
            },
          ],
        },
      ],
    });
  },
};
</script>

<style scoped lang="scss">
.line1 {
  margin: 20px;
  width: auto;
  height: 500px;
  background-color: #fff;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
