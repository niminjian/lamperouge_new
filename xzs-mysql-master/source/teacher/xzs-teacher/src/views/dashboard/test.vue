<template>
  <div id="app">
    <div class="result" v-if=end>
      <p>答题结束，一共答对{{rightNum}}道题！</p>
    </div>
    <div class="start" v-if=!start v-on:click="isStart">
      开始答题
    </div>
    <div v-if="start&&!end">
      <div class="timer">
        <p>倒计时：{{timeout}}</p>
      </div>
      <div class="questions">
        <p>{{index+1}}.{{questions[index].ques}}</p>
        <ul>
          <li :tag="questions[index].ans1" v-on:click="comfirm" :class="isSelected?(questions[index].ans1==questions[index].riAns ? 'rightAns' : 'wrongAns'):''">
            A.{{questions[index].ans1}}
            <span v-if = isSelected>
                            {{questions[index].ans1 == questions[index].riAns ? right : wrong}}
                        </span>
          </li>
          <li :tag="questions[index].ans2" v-on:click="comfirm" :class="isSelected?(questions[index].ans2==questions[index].riAns ? 'rightAns' : 'wrongAns'):''">
            B.{{questions[index].ans2}}
            <span v-if = isSelected>
                            {{questions[index].ans2 == questions[index].riAns ? right : wrong}}
                        </span>
          </li>
          <li :tag="questions[index].ans3" v-on:click="comfirm" :class="isSelected?(questions[index].ans3==questions[index].riAns ? 'rightAns' : 'wrongAns'):''">
            C.{{questions[index].ans3}}
            <span v-if = isSelected>
                            {{questions[index].ans3 == questions[index].riAns ? right : wrong}}
                        </span>
          </li>
          <li :tag="questions[index].ans4" v-on:click="comfirm" :class="isSelected?(questions[index].ans4==questions[index].riAns ? 'rightAns' : 'wrongAns'):''">
            D.{{questions[index].ans4}}
            <span v-if = isSelected>
                            {{questions[index].ans4 == questions[index].riAns ? right : wrong}}
                        </span>
          </li>
        </ul>
      </div>
      <div class="timer">
        <p>已答对{{rightNum}}题</p>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
	name: "test"
  }
</script>

<style scoped>

</style>
