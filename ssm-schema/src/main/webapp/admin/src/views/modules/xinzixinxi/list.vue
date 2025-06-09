<template>
  <div class="main-content">
    <!-- 列表页 -->
    <div v-if="showFlag">
      <el-form :inline="true" :model="searchForm" class="form-content">
                                            <el-form-item label="标题">
                <el-input v-model="searchForm.biaoti" 
                    placeholder="标题" clearable></el-input>
              </el-form-item>
                                                                  <el-form-item label="员工工号">
                <el-input v-model="searchForm.yuangonggonghao" 
                    placeholder="员工工号" clearable></el-input>
              </el-form-item>
                                                                  <el-form-item label="员工姓名">
                <el-input v-model="searchForm.yuangongxingming" 
                    placeholder="员工姓名" clearable></el-input>
              </el-form-item>
                                                                                                                                                                                      <el-form-item>
          <el-button round @click="search()">查询</el-button>
          <el-button
            v-if="isAuth('xinzixinxi','新增')"
            type="primary"
            @click="addOrUpdateHandler()"
            round
          >新增</el-button>
          <el-button
            v-if="isAuth('xinzixinxi','删除')"
            :disabled="dataListSelections.length <= 0"
            type="danger"
            @click="deleteHandler()"
            round
          >删除</el-button>
                  </el-form-item>
      </el-form>
      <div class="table-content">
        <el-table
            v-if="isAuth('xinzixinxi','查看')"
            :data="dataList"
            border
            v-loading="dataListLoading"
            @selection-change="selectionChangeHandler"
            style="width: 100%;">
            <el-table-column
                type="selection"
                header-align="center"
                align="center"
                width="50">
            </el-table-column>
                                            <el-table-column
                    prop="biaoti"
                    header-align="center"
                    align="center"
                    sortable
                    label="标题">
                    <template slot-scope="scope">
                      {{scope.row.biaoti}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="yuangonggonghao"
                    header-align="center"
                    align="center"
                    sortable
                    label="员工工号">
                    <template slot-scope="scope">
                      {{scope.row.yuangonggonghao}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="yuangongxingming"
                    header-align="center"
                    align="center"
                    sortable
                    label="员工姓名">
                    <template slot-scope="scope">
                      {{scope.row.yuangongxingming}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="jibenxinzi"
                    header-align="center"
                    align="center"
                    sortable
                    label="基本薪资">
                    <template slot-scope="scope">
                      {{scope.row.jibenxinzi}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="jiabanfei"
                    header-align="center"
                    align="center"
                    sortable
                    label="加班费">
                    <template slot-scope="scope">
                      {{scope.row.jiabanfei}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="jiangjin"
                    header-align="center"
                    align="center"
                    sortable
                    label="奖金">
                    <template slot-scope="scope">
                      {{scope.row.jiangjin}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="gaowenbutie"
                    header-align="center"
                    align="center"
                    sortable
                    label="高温补贴">
                    <template slot-scope="scope">
                      {{scope.row.gaowenbutie}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="qingjiaxinzi"
                    header-align="center"
                    align="center"
                    sortable
                    label="请假薪资">
                    <template slot-scope="scope">
                      {{scope.row.qingjiaxinzi}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="qita"
                    header-align="center"
                    align="center"
                    sortable
                    label="其他">
                    <template slot-scope="scope">
                      {{scope.row.qita}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="shifagongzi"
                    header-align="center"
                    align="center"
                    sortable
                    label="实发工资">
                    <template slot-scope="scope">
                      {{scope.row.shifagongzi}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="dengjiriqi"
                    header-align="center"
                    align="center"
                    sortable
                    label="登记日期">
                    <template slot-scope="scope">
                      {{scope.row.dengjiriqi}}
                    </template>
                </el-table-column>
                                                    <el-table-column
                header-align="center"
                align="center"
                label="操作">
                <template slot-scope="scope">
                                <el-button v-if="isAuth('xinzixinxi','查看')" type="text" icon="el-icon-edit" size="small" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
                                                <el-button v-if="isAuth('xinzixinxi','修改')" type="text" icon="el-icon-edit" size="small" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>
                <el-button v-if="isAuth('xinzixinxi','删除')" type="text" icon="el-icon-delete" size="small" @click="deleteHandler(scope.row.id)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
                                                                                                                                                                                                <el-pagination
          @size-change="sizeChangeHandle"
          @current-change="currentChangeHandle"
          :current-page="pageIndex"
          :page-sizes="[10, 20, 50, 100]"
          :page-size="pageSize"
          :total="totalPage"
          layout="total, sizes, prev, pager, next, jumper"
          class="pagination-content"
        ></el-pagination>
      </div>
    </div>
    <!-- 添加/修改页面  将父组件的search方法传递给子组件-->
    <add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>

    
    
      </div>
</template>
<script>
import AddOrUpdate from "./add-or-update";
export default {
  data() {
    return {
                                                                                                                                                                                                                                                      searchForm: {
        key: ""
      },
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      chartVisiable: false,
      addOrUpdateFlag:false,
          };
  },
  mounted() {
    this.init();
    this.getDataList();
  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
    }
  },
  components: {
    AddOrUpdate,
      },
  methods: {
                init () {
                                                                                                                                                                                                                                                                                                                                                        },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },
    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
      }
                                          if(this.searchForm.biaoti!='' && this.searchForm.biaoti!=undefined){
            params['biaoti'] = '%' + this.searchForm.biaoti + '%'
          }
                                                            if(this.searchForm.yuangonggonghao!='' && this.searchForm.yuangonggonghao!=undefined){
            params['yuangonggonghao'] = '%' + this.searchForm.yuangonggonghao + '%'
          }
                                                            if(this.searchForm.yuangongxingming!='' && this.searchForm.yuangongxingming!=undefined){
            params['yuangongxingming'] = '%' + this.searchForm.yuangongxingming + '%'
          }
                                                                                                                                                                                                              this.$http({
        url: "xinzixinxi/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
        // 下载
    download(file){
      window.open(`${file}`)
    },
    // 删除
    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "xinzixinxi/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "操作成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
