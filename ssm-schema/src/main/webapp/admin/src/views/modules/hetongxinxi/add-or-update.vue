<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
      <el-row>
                  <el-col :span="12">
        <el-form-item v-if="type!='info'" label="合同编号" prop="hetongbianhao">
            <el-input v-model="ruleForm.hetongbianhao" 
                placeholder="合同编号" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.hetongbianhao" label="合同编号" prop="hetongbianhao">
              <el-input v-model="ruleForm.hetongbianhao" 
                placeholder="合同编号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="房源名称" prop="fangyuanmingcheng">
          <el-input v-model="ruleForm.fangyuanmingcheng" 
              placeholder="房源名称" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.fangyuanmingcheng" label="房源名称" prop="fangyuanmingcheng">
              <el-input v-model="ruleForm.fangyuanmingcheng" 
                placeholder="房源名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="格局" prop="geju">
          <el-input v-model="ruleForm.geju" 
              placeholder="格局" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.geju" label="格局" prop="geju">
              <el-input v-model="ruleForm.geju" 
                placeholder="格局" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="面积" prop="mianji">
          <el-input v-model="ruleForm.mianji" 
              placeholder="面积" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.mianji" label="面积" prop="mianji">
              <el-input v-model="ruleForm.mianji" 
                placeholder="面积" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="地址" prop="dizhi">
          <el-input v-model="ruleForm.dizhi" 
              placeholder="地址" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.dizhi" label="地址" prop="dizhi">
              <el-input v-model="ruleForm.dizhi" 
                placeholder="地址" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="24">  
        <el-form-item v-if="type!='info'" label="图片" prop="tupian">
          <file-upload
          tip="点击上传图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.tupian?ruleForm.tupian:''"
          @change="tupianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.tupian" label="图片" prop="tupian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.tupian.split(',')" :src="item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="价格" prop="jiage">
          <el-input v-model="ruleForm.jiage" 
              placeholder="价格" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.jiage" label="价格" prop="jiage">
              <el-input v-model="ruleForm.jiage" 
                placeholder="价格" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="租期" prop="zuqi">
          <el-input v-model="ruleForm.zuqi" 
              placeholder="租期" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zuqi" label="租期" prop="zuqi">
              <el-input v-model="ruleForm.zuqi" 
                placeholder="租期" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'"  label="总金额" prop="zongjine">
            <el-input v-model="zongjine"
                placeholder="总金额" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zongjine" label="总金额" prop="zongjine">
              <el-input v-model="ruleForm.zongjine" 
                placeholder="总金额" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'" label="入住时间" prop="ruzhushijian">
            <el-date-picker
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd"
                v-model="ruleForm.ruzhushijian" 
                type="date"
                placeholder="入住时间">
            </el-date-picker> 
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.ruzhushijian" label="入住时间" prop="ruzhushijian">
              <el-input v-model="ruleForm.ruzhushijian" 
                placeholder="入住时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'" label="终止时间" prop="zhongzhishijian">
            <el-date-picker
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd"
                v-model="ruleForm.zhongzhishijian" 
                type="date"
                placeholder="终止时间">
            </el-date-picker> 
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zhongzhishijian" label="终止时间" prop="zhongzhishijian">
              <el-input v-model="ruleForm.zhongzhishijian" 
                placeholder="终止时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="房东账号" prop="fangdongzhanghao">
          <el-input v-model="ruleForm.fangdongzhanghao" 
              placeholder="房东账号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.fangdongzhanghao" label="房东账号" prop="fangdongzhanghao">
              <el-input v-model="ruleForm.fangdongzhanghao" 
                placeholder="房东账号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="房东姓名" prop="fangdongxingming">
          <el-input v-model="ruleForm.fangdongxingming" 
              placeholder="房东姓名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.fangdongxingming" label="房东姓名" prop="fangdongxingming">
              <el-input v-model="ruleForm.fangdongxingming" 
                placeholder="房东姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="联系电话" prop="lianxidianhua">
          <el-input v-model="ruleForm.lianxidianhua" 
              placeholder="联系电话" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.lianxidianhua" label="联系电话" prop="lianxidianhua">
              <el-input v-model="ruleForm.lianxidianhua" 
                placeholder="联系电话" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="租客账号" prop="zukezhanghao">
          <el-input v-model="ruleForm.zukezhanghao" 
              placeholder="租客账号" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zukezhanghao" label="租客账号" prop="zukezhanghao">
              <el-input v-model="ruleForm.zukezhanghao" 
                placeholder="租客账号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="租客姓名" prop="zukexingming">
          <el-input v-model="ruleForm.zukexingming" 
              placeholder="租客姓名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zukexingming" label="租客姓名" prop="zukexingming">
              <el-input v-model="ruleForm.zukexingming" 
                placeholder="租客姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="联系方式" prop="lianxifangshi">
          <el-input v-model="ruleForm.lianxifangshi" 
              placeholder="联系方式" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.lianxifangshi" label="联系方式" prop="lianxifangshi">
              <el-input v-model="ruleForm.lianxifangshi" 
                placeholder="联系方式" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'" label="签订时间" prop="qiandingshijian">
            <el-date-picker
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd"
                v-model="ruleForm.qiandingshijian" 
                type="date"
                placeholder="签订时间">
            </el-date-picker> 
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.qiandingshijian" label="签订时间" prop="qiandingshijian">
              <el-input v-model="ruleForm.qiandingshijian" 
                placeholder="签订时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                          </el-row>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      <el-form-item>
                <el-button v-if="type!='info'" type="primary" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    
    
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
      id: '',
      type: '',
            ruleForm: {
                        hetongbianhao: this.getUUID(),
                                fangyuanmingcheng: '',
                                geju: '',
                                mianji: '',
                                dizhi: '',
                                tupian: '',
                                jiage: '',
                                zuqi: '',
                                zongjine: '',
                                ruzhushijian: '',
                                zhongzhishijian: '',
                                fangdongzhanghao: '',
                                fangdongxingming: '',
                                lianxidianhua: '',
                                zukezhanghao: '',
                                zukexingming: '',
                                lianxifangshi: '',
                                qiandingshijian: '',
                                ispay: '',
                      },
                                                                                                                                                                                                                                                                                      rules: {
                  hetongbianhao: [
                                                                                              ],
                  fangyuanmingcheng: [
                                                                                              ],
                  geju: [
                                                                                              ],
                  mianji: [
                                                                                              ],
                  dizhi: [
                                                                                              ],
                  tupian: [
                                                                                              ],
                  jiage: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  zuqi: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  zongjine: [
                                                                                              ],
                  ruzhushijian: [
                                                                                              ],
                  zhongzhishijian: [
                                                                                              ],
                  fangdongzhanghao: [
                                                                                              ],
                  fangdongxingming: [
                                                                                              ],
                  lianxidianhua: [
                                                                                              ],
                  zukezhanghao: [
                                                                                              ],
                  zukexingming: [
                                                                                              ],
                  lianxifangshi: [
                                                                                              ],
                  qiandingshijian: [
                                                                                              ],
                  ispay: [
                                                                                              ],
              }
    };
  },
  props: ["parent"],
  computed: {
                                                                                                            zongjine:{
                                                                                                                                                                                                                                                                                                      get: function () {
        return 1*this.ruleForm.jiage*this.ruleForm.zuqi
      }
    },
                                                                                                                                      },
  methods: {
        // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
                    if(o=='hetongbianhao'){
            this.ruleForm.hetongbianhao = obj[o];
            continue;
          }
                    if(o=='fangyuanmingcheng'){
            this.ruleForm.fangyuanmingcheng = obj[o];
            continue;
          }
                    if(o=='geju'){
            this.ruleForm.geju = obj[o];
            continue;
          }
                    if(o=='mianji'){
            this.ruleForm.mianji = obj[o];
            continue;
          }
                    if(o=='dizhi'){
            this.ruleForm.dizhi = obj[o];
            continue;
          }
                    if(o=='tupian'){
            this.ruleForm.tupian = obj[o];
            continue;
          }
                    if(o=='jiage'){
            this.ruleForm.jiage = obj[o];
            continue;
          }
                    if(o=='zuqi'){
            this.ruleForm.zuqi = obj[o];
            continue;
          }
                    if(o=='zongjine'){
            this.ruleForm.zongjine = obj[o];
            continue;
          }
                    if(o=='ruzhushijian'){
            this.ruleForm.ruzhushijian = obj[o];
            continue;
          }
                    if(o=='zhongzhishijian'){
            this.ruleForm.zhongzhishijian = obj[o];
            continue;
          }
                    if(o=='fangdongzhanghao'){
            this.ruleForm.fangdongzhanghao = obj[o];
            continue;
          }
                    if(o=='fangdongxingming'){
            this.ruleForm.fangdongxingming = obj[o];
            continue;
          }
                    if(o=='lianxidianhua'){
            this.ruleForm.lianxidianhua = obj[o];
            continue;
          }
                    if(o=='zukezhanghao'){
            this.ruleForm.zukezhanghao = obj[o];
            continue;
          }
                    if(o=='zukexingming'){
            this.ruleForm.zukexingming = obj[o];
            continue;
          }
                    if(o=='lianxifangshi'){
            this.ruleForm.lianxifangshi = obj[o];
            continue;
          }
                    if(o=='qiandingshijian'){
            this.ruleForm.qiandingshijian = obj[o];
            continue;
          }
                    if(o=='ispay'){
            this.ruleForm.ispay = obj[o];
            continue;
          }
                  }
                                                                                                                                                                                                                                                                                                                              }
            // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
                                                                                                                                                                                                                                                                                      this.ruleForm.fangdongzhanghao = json.fangdongzhanghao
                                                this.ruleForm.fangdongxingming = json.fangdongxingming
                                                this.ruleForm.lianxidianhua = json.lianxidianhua
                                                                                                                                            } else {
          this.$message.error(data.msg);
        }
      });
                                                                                                                                                                                                                                                                                                                                                                                    },
                                                                                                                                                                // 多级联动参数
                                                                                                                                                                                                          info(id) {
      this.$http({
        url: `hetongxinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.ruleForm = data.data;
        } else {
          this.$message.error(data.msg);
        }
      });
    },
        // 提交
    onSubmit() {
                  // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
              this.ruleForm.zongjine = this.zongjine
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                                                                                                                                                                                                                                                                                                                                                                                          this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `hetongxinxi/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.hetongxinxiCrossAddOrUpdateFlag = false;
                  this.parent.search();
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.hetongxinxiCrossAddOrUpdateFlag = false;
    },
                                                                                    tupianUploadChange(fileUrls) {
                this.ruleForm.tupian = fileUrls;
            },
                                                                                                                                                                          }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
</style>
