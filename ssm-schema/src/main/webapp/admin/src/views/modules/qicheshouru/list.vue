<template>
  <div class="main-content">
    <!-- 列表页 -->
    <div v-if="showFlag">
      <el-form :inline="true" :model="searchForm" class="form-content">
                                            <el-form-item label="车辆编号">
                <el-input v-model="searchForm.cheliangbianhao" 
                    placeholder="车辆编号" clearable></el-input>
              </el-form-item>
                                                                  <el-form-item label="车辆品牌">
                <el-input v-model="searchForm.cheliangpinpai" 
                    placeholder="车辆品牌" clearable></el-input>
              </el-form-item>
                                                                                                                                                                                      <el-form-item>
          <el-button round @click="search()">查询</el-button>
          <el-button
            v-if="isAuth('qicheshouru','新增')"
            type="primary"
            @click="addOrUpdateHandler()"
            round
          >新增</el-button>
          <el-button
            v-if="isAuth('qicheshouru','删除')"
            :disabled="dataListSelections.length <= 0"
            type="danger"
            @click="deleteHandler()"
            round
          >删除</el-button>
                    <el-button
            v-if="isAuth('qicheshouru','报表')"
            type="info"
            @click="chartDialog()"
            round
          >统计报表</el-button>
                  </el-form-item>
      </el-form>
      <div class="table-content">
        <el-table
            v-if="isAuth('qicheshouru','查看')"
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
                    prop="cheliangbianhao"
                    header-align="center"
                    align="center"
                    sortable
                    label="车辆编号">
                    <template slot-scope="scope">
                      {{scope.row.cheliangbianhao}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="cheliangpinpai"
                    header-align="center"
                    align="center"
                    sortable
                    label="车辆品牌">
                    <template slot-scope="scope">
                      {{scope.row.cheliangpinpai}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="cheliangxinghao"
                    header-align="center"
                    align="center"
                    sortable
                    label="车辆型号">
                    <template slot-scope="scope">
                      {{scope.row.cheliangxinghao}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="chepaihao"
                    header-align="center"
                    align="center"
                    sortable
                    label="车牌号">
                    <template slot-scope="scope">
                      {{scope.row.chepaihao}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="zulinzongshouru"
                    header-align="center"
                    align="center"
                    sortable
                    label="租赁总收入">
                    <template slot-scope="scope">
                      {{scope.row.zulinzongshouru}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="weihuzhichu"
                    header-align="center"
                    align="center"
                    sortable
                    label="维护支出">
                    <template slot-scope="scope">
                      {{scope.row.weihuzhichu}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="qitafeiyong"
                    header-align="center"
                    align="center"
                    sortable
                    label="其他费用">
                    <template slot-scope="scope">
                      {{scope.row.qitafeiyong}}
                    </template>
                </el-table-column>
                                                            <el-table-column
                    prop="shijizongshouru"
                    header-align="center"
                    align="center"
                    sortable
                    label="实际总收入">
                    <template slot-scope="scope">
                      {{scope.row.shijizongshouru}}
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
                                                                                                <el-table-column
                header-align="center"
                align="center"
                label="操作">
                <template slot-scope="scope">
                                <el-button v-if="isAuth('qicheshouru','查看')" type="text" icon="el-icon-edit" size="small" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
                                                <el-button v-if="isAuth('qicheshouru','修改')" type="text" icon="el-icon-edit" size="small" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>
                <el-button v-if="isAuth('qicheshouru','删除')" type="text" icon="el-icon-delete" size="small" @click="deleteHandler(scope.row.id)">删除</el-button>
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

    
    
        <el-dialog
      title="统计报表"
      :visible.sync="chartVisiable"
      width="800">  
                                                                                                                        <div id="shijizongshouruChart" style="width:100%;height:600px;"></div>
                                                <span slot="footer" class="dialog-footer">
        <el-button @click="chartDialog">返回</el-button>
      </span>
    </el-dialog>
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
                chartDialog() {
      this.chartVisiable = !this.chartVisiable;
      this.$nextTick(()=>{
                                                                                                           // chepaihao chepaihao
                                                                                                                    //  shijizongshouru
                                                                                           // xcolumn ycolumn chepaihao shijizongshouru
                var shijizongshouruChart = this.$echarts.init(document.getElementById("shijizongshouruChart"),'macarons');
        this.$http({
            url: `value/qicheshouru/chepaihao/shijizongshouru`,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
                    xAxis.push(res[i].chepaihao);
                    yAxis.push(res[i].total);
                    pArray.push({
                    value: res[i].total,
                    name: res[i].chepaihao
                    })
                    var option = {};
                                        option = {
                        tooltip: {
                          trigger: 'item',
                          formatter: '{b} : {c}'
                        },
                        title: {
                            text: '汽车收入',
                            left: 'center'
                        },
                        xAxis: {
                            type: 'category',
                            data: xAxis
                        },
                        yAxis: {
                            type: 'value'
                        },
                        series: [{
                            data: yAxis,
                            type: 'bar'
                        }]
                    };
                                        // 使用刚指定的配置项和数据显示图表。
                    shijizongshouruChart.setOption(option);
                    //根据窗口的大小变动图表
                    window.onresize = function() {
                        shijizongshouruChart.resize();
                    };
                }
            }
        });
              })
    },
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
                                          if(this.searchForm.cheliangbianhao!='' && this.searchForm.cheliangbianhao!=undefined){
            params['cheliangbianhao'] = '%' + this.searchForm.cheliangbianhao + '%'
          }
                                                            if(this.searchForm.cheliangpinpai!='' && this.searchForm.cheliangpinpai!=undefined){
            params['cheliangpinpai'] = '%' + this.searchForm.cheliangpinpai + '%'
          }
                                                                                                                                                                                                              this.$http({
        url: "qicheshouru/page",
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
          url: "qicheshouru/delete",
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
