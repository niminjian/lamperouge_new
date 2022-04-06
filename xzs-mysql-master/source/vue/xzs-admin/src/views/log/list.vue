<template>
  <div class="app-container">
    <el-form :model="queryParam" ref="queryForm" :inline="true" align="center">
      <el-form-item label="用户Id：">
        <el-input v-model="queryParam.userId"></el-input>
      </el-form-item>
      <el-form-item label="用户名：">
        <el-input v-model="queryParam.userName"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm">查询</el-button>
      </el-form-item>
    </el-form>

    <el-table class="log-table" v-loading="listLoading" :data="tableData" border fit highlight-current-row style="width: 100%"  cell-style="font-weight: 700;">
      <el-table-column prop="id" label="Id" width="100" />
      <el-table-column prop="userName" label="用户名" width="150" />
      <el-table-column prop="realName" label="真实姓名" width="150" />
      <el-table-column prop="content" label="动态" />
      <el-table-column prop="createTime" label="创建时间" width="160px"/>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="queryParam.pageIndex" :limit.sync="queryParam.pageSize"
                @pagination="search"/>
  </div>
</template>

<style lang="scss">
.app-container {  //给最大的选择器指定样式
  width: 100%;
  height: 100vh;
  /*background: url("../../assets/log.jpg") center center no-repeat;*/
  background-size: 100% 100%;
}

/*最外层透明*/
.log-table, .el-table__expanded-cell{
  background-color: rgba(255, 255, 255, 0.3);
}
/* 表格内背景颜色 */
.log-table th,
.log-table tr,
.log-table td {
  background-color: rgba(255, 255, 255, 0.3);
}
.el-form{
  .el-form-item {
    background-color: rgba(255, 255, 255, 0.5);
  }
}
</style>


<script>
import Pagination from '@/components/Pagination'
import userApi from '@/api/user'

export default {
  components: { Pagination },
  data () {
    return {
      queryParam: {
        userId: null,
        userName: null,
        pageIndex: 1,
        pageSize: 10
      },
      listLoading: true,
      tableData: [],
      total: 0
    }
  },
  created () {
    let userId = this.$route.query.userId
    if (userId && parseInt(userId) !== 0) {
      this.queryParam.userId = userId
    }
    this.search()
  },
  methods: {
    search () {
      this.listLoading = true
      userApi.getUserEventPageList(this.queryParam).then(data => {
        const re = data.response
        this.tableData = re.list
        this.total = re.total
        this.queryParam.pageIndex = re.pageNum
        this.listLoading = false
      })
    },
    submitForm () {
      this.queryParam.pageIndex = 1
      this.search()
    }
  }
}
</script>
