<template>
  <div class="main-content">
    <!-- 列表页 -->
    <div v-if="showFlag">
      <el-form :inline="true" :model="searchForm" class="form-content">
                                            <el-form-item label="用户名">
                <el-input v-model="searchForm.yonghuming" 
                    placeholder="用户名" clearable></el-input>
              </el-form-item>
                                                                                                                                                                                                                                  <el-form-item label="登记时间">
                <el-date-picker
                    v-model="searchForm.dengjishijianstart"  
                    type="date"
                    placeholder="登记时间">
                </el-date-picker>
                至
                <el-date-picker
                    v-model="searchForm.dengjishijianend" 
                    type="date"
                    placeholder="登记时间">
                </el-date-picker>
            </el-form-item>
                                                                          <el-form-item>
          <el-button round @click="search()">查询</el-button>
          <el-button
            v-if="isAuth('gerenjiankangdaka','新增')"
            type="primary"
            @click="addOrUpdateHandler()"
            round
          >新增</el-button>
          <el-button
            v-if="isAuth('gerenjiankangdaka','删除')"
            :disabled="dataListSelections.length <= 0"
            type="danger"
            @click="deleteHandler()"
            round
          >删除</el-button>
                  </el-form-item>
      </el-form>
      <div class="table-content">
        <el-table
            v-if="isAuth('gerenjiankangdaka','查看')"
            :data="dataList"
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
                    prop="yonghuming"
                    header-align="center"
                    align="center"
                    sortable
                    label="用户名">
                    <template slot-scope="scope">
                      {{scope.row.yonghuming}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="yonghuxingming"
                    header-align="center"
                    align="center"
                    sortable
                    label="用户姓名">
                    <template slot-scope="scope">
                      {{scope.row.yonghuxingming}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="shenfenzheng"
                    header-align="center"
                    align="center"
                    sortable
                    label="身份证">
                    <template slot-scope="scope">
                      {{scope.row.shenfenzheng}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="jinqijuzhudizhi"
                    header-align="center"
                    align="center"
                    sortable
                    label="近期居住地址">
                    <template slot-scope="scope">
                      {{scope.row.jinqijuzhudizhi}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="gerentiwenqingkuang"
                    header-align="center"
                    align="center"
                    sortable
                    label="个人体温情况">
                    <template slot-scope="scope">
                      {{scope.row.gerentiwenqingkuang}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="shisitianneicengjuzhuhuoqianwangyiqinggaofadi"
                    header-align="center"
                    align="center"
                    sortable
                    label="十四天内曾居住或前往疫情高发地">
                    <template slot-scope="scope">
                      {{scope.row.shisitianneicengjuzhuhuoqianwangyiqinggaofadi}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="liangzhouneiyouyuquezhenhuanzhejiechu"
                    header-align="center"
                    align="center"
                    sortable
                    label="两周内有与确诊患者接触">
                    <template slot-scope="scope">
                      {{scope.row.liangzhouneiyouyuquezhenhuanzhejiechu}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="chuxianbushizhengzhuang"
                    header-align="center"
                    align="center"
                    sortable
                    label="出现不适症状">
                    <template slot-scope="scope">
                      {{scope.row.chuxianbushizhengzhuang}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="yiyueneishifouyouguowaihuoshengwailvyoushi"
                    header-align="center"
                    align="center"
                    sortable
                    label="一月内是否有国外或省外旅游史">
                    <template slot-scope="scope">
                      {{scope.row.yiyueneishifouyouguowaihuoshengwailvyoushi}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="beizhu"
                    header-align="center"
                    align="center"
                    sortable
                    label="备注">
                    <template slot-scope="scope">
                      {{scope.row.beizhu}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="dengjishijian"
                    header-align="center"
                    align="center"
                    sortable
                    label="登记时间">
                    <template slot-scope="scope">
                      {{scope.row.dengjishijian}}
                    </template>
                </el-table-column>
                                                              <el-table-column prop="tupian" 
                    header-align="center"
                    align="center" 
                    width="200" 
                    label="图片">
                    <template slot-scope="scope">
                      <div v-if="scope.row.tupian">
                        <img :src="scope.row.tupian.split(',')[0]" width="100" height="100">
                      </div>
                      <div v-else>无图片</div>
                    </template>
                  </el-table-column>
                                                                                                <el-table-column
                header-align="center"
                align="center"
                label="操作">
                <template slot-scope="scope">
                                <el-button v-if="isAuth('gerenjiankangdaka','查看')" type="text" icon="el-icon-edit" size="small" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
                                                <el-button v-if="isAuth('gerenjiankangdaka','修改')" type="text" icon="el-icon-edit" size="small" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>
                <el-button v-if="isAuth('gerenjiankangdaka','删除')" type="text" icon="el-icon-delete" size="small" @click="deleteHandler(scope.row.id)">删除</el-button>
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
                                          if(this.searchForm.yonghuming!='' && this.searchForm.yonghuming!=undefined){
            params['yonghuming'] = '%' + this.searchForm.yonghuming + '%'
          }
                                                                                                                                                                                                                                                                  if(this.searchForm.dengjishijianstart!='' && this.searchForm.dengjishijianstart!=undefined ){
            params['dengjishijianstart'] = this.searchForm.dengjishijianstart
          }
          if(this.searchForm.dengjishijianend!='' && this.searchForm.dengjishijianend!=undefined){
            params['dengjishijianend'] = this.searchForm.dengjishijianend
          }
                                                                          this.$http({
        url: "gerenjiankangdaka/page",
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
          url: "gerenjiankangdaka/delete",
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
