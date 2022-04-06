<template>
  <div class="app-container">
    <el-form
      :model="form"
      ref="form"
      label-width="100px"
      v-loading="formLoading"
      :rules="rules"
    >
      <el-form-item label="年级：" prop="level" required>
        <el-select
          v-model="form.level"
          placeholder="年级"
          @change="levelChange"
        >
          <el-option
            v-for="item in levelEnum"
            :key="item.key"
            :value="item.key"
            :label="item.value"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="学科：" prop="subjectId" required>
        <el-select v-model="form.subjectId" placeholder="学科">
          <el-option
            v-for="item in subjectFilter"
            :key="item.id"
            :value="item.id"
            :label="item.name + ' ( ' + item.levelName + ' )'"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="试卷类型：" prop="paperType" required>
        <el-select v-model="form.paperType" placeholder="试卷类型">
          <el-option
            v-for="item in paperTypeEnum"
            :key="item.key"
            :value="item.key"
            :label="item.value"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="时间限制：" required v-show="form.paperType === 4">
        <el-date-picker
          v-model="form.limitDateTime"
          value-format="yyyy-MM-dd HH:mm:ss"
          type="datetimerange"
          range-separator="至"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item label="试卷名称：" prop="name" required>
        <el-input v-model="form.name" />
      </el-form-item>
      <el-form-item
        :key="index"
        :label="'标题' + (index + 1) + '：'"
        required
        v-for="(titleItem, index) in form.titleItems"
      >
        <el-input v-model="titleItem.name" style="width: 80%" />
        <el-button
          type="text"
          class="link-left"
          style="margin-left: 20px"
          size="mini"
          @click="addQuestion(titleItem)"
        >
          添加题目
        </el-button>
        <el-button
          type="text"
          class="link-left"
          size="mini"
          @click="form.titleItems.splice(index, 1)"
          >删除</el-button
        >
        <el-card
          class="exampaper-item-box"
          v-if="titleItem.questionItems.length !== 0"
        >
          <el-form-item
            :key="questionIndex"
            :label="'题目' + (questionIndex + 1) + '：'"
            v-for="(questionItem, questionIndex) in titleItem.questionItems"
            style="margin-bottom: 15px"
          >
            <el-row>
              <el-col :span="23">
                <QuestionShow
                  :qType="questionItem.questionType"
                  :question="questionItem"
                />
              </el-col>
              <el-col :span="1">
                <el-button
                  type="text"
                  size="mini"
                  @click="titleItem.questionItems.splice(questionIndex, 1)"
                  >删除
                </el-button>
              </el-col>
            </el-row>
          </el-form-item>
        </el-card>
      </el-form-item>
      <el-form-item label="建议时长：" prop="suggestTime" required>
        <el-input v-model="form.suggestTime" placeholder="分钟" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm">提交</el-button>
        <el-button @click="resetForm">重置</el-button>
        <el-button type="success" @click="addTitle">添加标题</el-button>
        <el-button type="success" plain @click="addPaper(titleItem)"
          >快速组卷</el-button
        >
      </el-form-item>
    </el-form>
    <!-- 快速组卷弹窗 -->
    <el-dialog :visible.sync="paperPage.showDialog" width="70%">
      <el-form :model="paperPage.queryParam" ref="queryForm" :inline="true">
        <el-form-item label="测试1ID：">
          <el-input v-model="paperPage.queryParam.id" clearable></el-input>
        </el-form-item>
        <el-form-item label="题型：">
          <el-select
            v-model="paperPage.queryParam.questionType"
            clearable
            @change="styleChange"
          >
            <el-option
              v-for="item in pageClass"
              :key="item.key"
              :value="item.value"
              :label="item.label"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="queryForm2">查询</el-button>
        </el-form-item>
      </el-form>
      <el-table
        v-loading="paperPage.listLoading"
        :data="paperPage.tableData"
        @selection-change="handleSelectionChange"
        border
        fit
        highlight-current-row
        style="width: 100%"
      >
        <el-table-column type="selection" width="35"></el-table-column>
        <el-table-column prop="id" label="Id" width="60px" />
        <el-table-column
          prop="questionType"
          label="题型"
          :formatter="questionTypeFormatter"
          width="70px"
        />
        <el-table-column prop="shortTitle" label="题干" show-overflow-tooltip />
      </el-table>
      <pagination
        v-show="paperPage.total > 0"
        :total="paperPage.total"
        :page.sync="paperPage.queryParam.pageIndex"
        :limit.sync="paperPage.queryParam.pageSize"
        @pagination="search"
      />
      <span slot="footer" class="dialog-footer">
        <el-button @click="paperPage.showDialog = false">取 消</el-button>
        <el-button type="primary" @click="confirmQuestionSelect2"
          >确定</el-button
        >
      </span>
    </el-dialog>
    <!-- 快速组卷弹窗 -->

    <el-dialog :visible.sync="questionPage.showDialog" width="70%">
      <el-form :model="questionPage.queryParam" ref="queryForm" :inline="true">
        <el-form-item label="测试2ID：">
          <el-input v-model="questionPage.queryParam.id" clearable></el-input>
        </el-form-item>
        <el-form-item label="题型：">
          <el-select v-model="questionPage.queryParam.questionType" clearable>
            <el-option
              v-for="item in questionTypeEnum"
              :key="item.key"
              :value="item.key"
              :label="item.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="queryForm">查询</el-button>
        </el-form-item>
      </el-form>
      <el-table
        v-loading="questionPage.listLoading"
        :data="questionPage.tableData"
        @selection-change="handleSelectionChange"
        border
        fit
        highlight-current-row
        style="width: 100%"
      >
        <el-table-column type="selection" width="35"></el-table-column>
        <el-table-column prop="id" label="Id" width="60px" />
        <el-table-column
          prop="questionType"
          label="题型"
          :formatter="questionTypeFormatter"
          width="70px"
        />
        <el-table-column prop="shortTitle" label="题干" show-overflow-tooltip />
      </el-table>
      <pagination
        v-show="questionPage.total > 0"
        :total="questionPage.total"
        :page.sync="questionPage.queryParam.pageIndex"
        :limit.sync="questionPage.queryParam.pageSize"
        @pagination="search"
      />
      <span slot="footer" class="dialog-footer">
        <el-button @click="questionPage.showDialog = false">取 消</el-button>
        <el-button type="primary" @click="confirmQuestionSelect"
          >确定</el-button
        >
      </span>
    </el-dialog>

    <el-card class="box-card" v-show="currentShowList[0]">
      <div slot="header" class="clearfix">
        <span class="title">选择题训练</span>
        <el-button
          style="float: right; padding: 3px 0"
          type="text"
          @click="currentShowList[0] = false"
          >删除</el-button
        >
      </div>
      <div>
        <div class="title item">
          第1题<el-button style="float: right; padding: 3px 0" type="text"
            >替换</el-button
          >
        </div>
        <div class="question">1+2=?</div>
        <div class="itemList">
          <p>A. 1</p>
          <p>B. 2</p>
          <p>C. 3</p>
          <p>D. 4</p>
        </div>
      </div>
      <div>
        <div class="title item">
          第2题<el-button style="float: right; padding: 3px 0" type="text"
            >替换</el-button
          >
        </div>
        <div class="question">π=?</div>
        <div class="itemList">
          <p>A. 3.15</p>
          <p>B. 3.14159</p>
          <p>C. 3</p>
          <p>D. 3.1416</p>
        </div>
      </div>
      <div>
        <div class="title item">
          第3题<el-button style="float: right; padding: 3px 0" type="text"
            >替换</el-button
          >
        </div>
        <div class="question">23*32=?</div>
        <div class="itemList">
          <p>A. 736</p>
          <p>B. 763</p>
          <p>C. 756</p>
          <p>D. 716</p>
        </div>
      </div>
    </el-card>
    <el-card class="box-card" v-show="currentShowList[1]">
      <div slot="header" class="clearfix">
        <span class="title">填空题训练</span>
        <el-button style="float: right; padding: 3px 0" type="text"
          >删除</el-button
        >
      </div>
      <div>
        <div class="title item">
          第1题<el-button style="float: right; padding: 3px 0" type="text"
            >替换</el-button
          >
        </div>
        <div class="question">衬衫的价格是___便士</div>
      </div>
      <div>
        <div class="title item">
          第2题<el-button style="float: right; padding: 3px 0" type="text"
            >替换</el-button
          >
        </div>
        <div class="question">万有引力公式___</div>
      </div>
      <div>
        <div class="title item">
          第3题<el-button style="float: right; padding: 3px 0" type="text"
            >替换</el-button
          >
        </div>
        <div class="question">奇变偶不变，___</div>
      </div>
    </el-card>

    <el-card class="box-card" v-show="currentShowList[2]">
      <div slot="header" class="clearfix">
        <span class="title">综合题训练</span>
        <el-button style="float: right; padding: 3px 0" type="text"
          >删除</el-button
        >
      </div>
      <div>
        <div class="title item">
          第1题<el-button style="float: right; padding: 3px 0" type="text"
            >替换</el-button
          >
        </div>
        <div class="question">
          东风洗染厂，每天用水量比过去节约20%，原有390吨水，现在比过去多用30天，现在每天用水多少吨?
        </div>
      </div>
      <div>
        <div class="title item">
          第2题<el-button style="float: right; padding: 3px 0" type="text"
            >替换</el-button
          >
        </div>
        <div class="question">
          一辆汽车从甲地开往乙地，每小时行驶28千米，4.5小时到达，要4小时到达，每小时要多行几千米?
        </div>
      </div>
      <div>
        <div class="title item">
          第3题<el-button style="float: right; padding: 3px 0" type="text"
            >替换</el-button
          >
        </div>
        <div class="question">
          一块平行四边形菜地，底与高的和是150米，它们的比是3∶2，求这块菜地的面积是多少平方米?
        </div>
      </div>
    </el-card>
  </div>
</template>

<script>
import { mapGetters, mapState, mapActions } from "vuex";
import Pagination from "@/components/Pagination";
import QuestionShow from "../question/components/Show";
import examPaperApi from "@/api/examPaper";
import questionApi from "@/api/question";

export default {
  components: { Pagination, QuestionShow },
  data() {
    return {
      form: {
        id: null,
        level: null,
        subjectId: null,
        paperType: 1,
        limitDateTime: [],
        name: "",
        suggestTime: null,
        titleItems: [],
      },
      subjectFilter: null,
      formLoading: false,
      rules: {
        level: [{ required: true, message: "请选择年级", trigger: "change" }],
        subjectId: [
          { required: true, message: "请选择学科", trigger: "change" },
        ],
        paperType: [
          { required: true, message: "请选择试卷类型", trigger: "change" },
        ],
        name: [{ required: true, message: "请输入试卷名称", trigger: "blur" }],
        suggestTime: [
          { required: true, message: "请输入建议时长", trigger: "blur" },
        ],
      },
      questionPage: {
        multipleSelection: [],
        showDialog: false,
        queryParam: {
          id: null,
          questionType: null,
          subjectId: 1,
          pageIndex: 1,
          pageSize: 5,
        },
        listLoading: true,
        tableData: [],
        total: 0,
      },
      currentTitleItem: null,
      currentShowList: [false, false, false],
      paperPage: {
        multipleSelection: [],
        showDialog: false,
        queryParam: {
          id: null,
          questionType: null,
          subjectId: 1,
          pageIndex: 1,
          pageSize: 5,
        },
        listLoading: true,
        tableData: [],
        total: 0,
      },
      pageClass: [
        {
          value: "0",
          label: "选择题训练",
        },
        {
          value: "1",
          label: "填空题训练",
        },
        {
          value: "2",
          label: "综合题训练",
        },
        {
          value: "3",
          label: "附加题训练",
        },
      ],
    };
  },
  created() {
    let id = this.$route.query.id;
    let _this = this;
    this.initSubject(function () {
      _this.subjectFilter = _this.subjects;
    });
    if (id && parseInt(id) !== 0) {
      _this.formLoading = true;
      examPaperApi.select(id).then((re) => {
        _this.form = re.response;
        _this.formLoading = false;
      });
    }
  },
  methods: {
    styleChange(val) {
      if (val === "0") {
        this.currentShowList[0] = true;
      } else if (val === "1") {
        this.currentShowList[1] = true;
      } else if (val === "2") {
        this.currentShowList[2] = true;
      }
    },
    addPaper(titleItem) {
      this.currentTitleItem = titleItem;
      this.paperPage.showDialog = true;
      this.search2();
    },
    search2() {
      this.paperPage.queryParam.subjectId = this.form.subjectId;
      this.paperPage.listLoading = true;
      questionApi.pageList(this.paperPage.queryParam).then((data) => {
        const re = data.response;
        this.paperPage.tableData = re.list;
        this.paperPage.total = re.total;
        this.paperPage.queryParam.pageIndex = re.pageNum;
        this.paperPage.listLoading = false;
      });
    },
    submitForm() {
      let _this = this;
      this.$refs.form.validate((valid) => {
        if (valid) {
          this.formLoading = true;
          examPaperApi
            .edit(this.form)
            .then((re) => {
              if (re.code === 1) {
                _this.$message.success(re.message);
                _this.delCurrentView(_this).then(() => {
                  _this.$router.push("/exam/paper/list");
                });
              } else {
                _this.$message.error(re.message);
                this.formLoading = false;
              }
            })
            .catch((e) => {
              this.formLoading = false;
            });
        } else {
          return false;
        }
      });
    },
    addTitle() {
      this.form.titleItems.push({
        name: "",
        questionItems: [],
      });
    },
    addQuestion(titleItem) {
      this.currentTitleItem = titleItem;
      this.questionPage.showDialog = true;
      this.search();
    },
    removeTitleItem(titleItem) {
      this.form.titleItems.remove(titleItem);
    },
    removeQuestion(titleItem, questionItem) {
      titleItem.questionItems.remove(questionItem);
    },
    queryForm() {
      this.questionPage.queryParam.pageIndex = 1;
      this.search();
    },
    queryForm2() {
      this.questionPage.queryParam.pageIndex = 1;
      this.search2();
    },
    confirmQuestionSelect() {
      let _this = this;
      this.questionPage.multipleSelection.forEach((q) => {
        questionApi.select(q.id).then((re) => {
          _this.currentTitleItem.questionItems.push(re.response);
        });
      });
      this.questionPage.showDialog = false;
    },
    confirmQuestionSelect2() {
      let _this = this;
      this.paperPage.multipleSelection.forEach((q) => {
        questionApi.select(q.id).then((re) => {
          _this.currentTitleItem.questionItems.push(re.response);
        });
      });
      this.paperPage.showDialog = false;
    },
    levelChange() {
      this.form.subjectId = null;
      this.subjectFilter = this.subjects.filter(
        (data) => data.level === this.form.level
      );
    },
    search() {
      this.questionPage.queryParam.subjectId = this.form.subjectId;
      this.questionPage.listLoading = true;
      questionApi.pageList(this.questionPage.queryParam).then((data) => {
        const re = data.response;
        this.questionPage.tableData = re.list;
        this.questionPage.total = re.total;
        this.questionPage.queryParam.pageIndex = re.pageNum;
        this.questionPage.listLoading = false;
      });
    },
    handleSelectionChange(val) {
      this.questionPage.multipleSelection = val;
    },
    questionTypeFormatter(row, column, cellValue, index) {
      return this.enumFormat(this.questionTypeEnum, cellValue);
    },
    subjectFormatter(row, column, cellValue, index) {
      return this.subjectEnumFormat(cellValue);
    },
    resetForm() {
      let lastId = this.form.id;
      this.$refs["form"].resetFields();
      this.form = {
        id: null,
        level: null,
        subjectId: null,
        paperType: 1,
        limitDateTime: [],
        name: "",
        suggestTime: null,
        titleItems: [],
      };
      this.form.id = lastId;
    },
    ...mapActions("exam", { initSubject: "initSubject" }),
    ...mapActions("tagsView", { delCurrentView: "delCurrentView" }),
  },
  computed: {
    ...mapGetters("enumItem", ["enumFormat"]),
    ...mapState("enumItem", {
      questionTypeEnum: (state) => state.exam.question.typeEnum,
      paperTypeEnum: (state) => state.exam.examPaper.paperTypeEnum,
      levelEnum: (state) => state.user.levelEnum,
    }),
    ...mapState("exam", { subjects: (state) => state.subjects }),
  },
};
</script>

<style scoped lang="scss" >
.exampaper-item-box {
  .q-title {
    margin: 0px 5px 0px 5px;
  }
  .q-item-content {
  }
}
.text {
  font-size: 15px;
}
.title {
  font-size: 20px;
  font-weight: bold;
}

.item {
  margin-bottom: 13px;
  padding-left: 20px;
}
.itemList {
  width: 80%;
  margin-left: 40px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.question {
  margin-left: 40px;
  font-size: 16px;
  font-weight: bold;
  margin-bottom: 10px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both;
}

.box-card {
  width: 93%;
  margin-left: 90px;
  margin-top: 30px;
}
</style>
