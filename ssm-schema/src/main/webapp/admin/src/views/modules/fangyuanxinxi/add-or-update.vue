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
        <el-form-item v-if="type!='info'" label="房源编号" prop="fangyuanbianhao">
            <el-input v-model="ruleForm.fangyuanbianhao" 
                placeholder="房源编号" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.fangyuanbianhao" label="房源编号" prop="fangyuanbianhao">
              <el-input v-model="ruleForm.fangyuanbianhao" 
                placeholder="房源编号" readonly></el-input>
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
        <el-form-item v-if="type!='info'"  label="状态" prop="zhuangtai">
          <el-select v-model="ruleForm.zhuangtai" placeholder="请选择状态">
            <el-option
                v-for="(item,index) in zhuangtaiOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.zhuangtai" label="状态" prop="zhuangtai">
              <el-input v-model="ruleForm.zhuangtai" 
                placeholder="状态" readonly></el-input>
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
        <el-form-item  v-if="type!='info'"  label="城市" prop="chengshi">
          <el-input v-model="ruleForm.chengshi" 
              placeholder="城市" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.chengshi" label="城市" prop="chengshi">
              <el-input v-model="ruleForm.chengshi" 
                placeholder="城市" readonly></el-input>
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
        <el-form-item v-if="type!='info'"  label="交通方便程度" prop="jiaotongfangbianchengdu">
          <el-select v-model="ruleForm.jiaotongfangbianchengdu" placeholder="请选择交通方便程度">
            <el-option
                v-for="(item,index) in jiaotongfangbianchengduOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.jiaotongfangbianchengdu" label="交通方便程度" prop="jiaotongfangbianchengdu">
              <el-input v-model="ruleForm.jiaotongfangbianchengdu" 
                placeholder="交通方便程度" readonly></el-input>
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
        <el-form-item v-if="type!='info'" label="发布时间" prop="fabushijian">
            <el-date-picker
                value-format="yyyy-MM-dd HH:mm:ss"
                v-model="ruleForm.fabushijian" 
                type="datetime"
                placeholder="发布时间">
            </el-date-picker>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.fabushijian" label="发布时间" prop="fabushijian">
              <el-input v-model="ruleForm.fabushijian" 
                placeholder="发布时间" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        </el-row>
                                                                                                                                                                                                                                                                                                                                                                                            <el-row>
            <el-col :span="24">
              <el-form-item v-if="type!='info'"  label="详情" prop="xiangqing">
                <editor 
                    style="min-width: 200px; max-width: 600px;"
                    v-model="ruleForm.xiangqing" 
                    class="editor" 
                    action="file/upload">
                </editor>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.xiangqing" label="详情" prop="xiangqing">
                    <span v-html="ruleForm.xiangqing"></span>
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
                        fangyuanbianhao: this.getUUID(),
                                fangyuanmingcheng: '',
                                mianji: '',
                                zhuangtai: '',
                                geju: '',
                                jiage: '',
                                chengshi: '',
                                tupian: '',
                                jiaotongfangbianchengdu: '',
                                dizhi: '',
                                xiangqing: '',
                                fangdongzhanghao: '',
                                fangdongxingming: '',
                                lianxidianhua: '',
                                fabushijian: '',
                      },
                                                                  zhuangtaiOptions: [],
                                                                                        jiaotongfangbianchengduOptions: [],
                                                                                                        rules: {
                  fangyuanbianhao: [
                                                                                              ],
                  fangyuanmingcheng: [
                                                                                              ],
                  mianji: [
                                                                                              ],
                  zhuangtai: [
                                                                                              ],
                  geju: [
                                                                                              ],
                  jiage: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                                                                                  ],
                  chengshi: [
                                                                                              ],
                  tupian: [
                                                                                              ],
                  jiaotongfangbianchengdu: [
                                                                                              ],
                  dizhi: [
                                                                                              ],
                  xiangqing: [
                                                                                              ],
                  fangdongzhanghao: [
                                                                                              ],
                  fangdongxingming: [
                                                                                              ],
                  lianxidianhua: [
                                                                                              ],
                  fabushijian: [
                                                                                              ],
              }
    };
  },
  props: ["parent"],
  computed: {
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
                    if(o=='fangyuanbianhao'){
            this.ruleForm.fangyuanbianhao = obj[o];
            continue;
          }
                    if(o=='fangyuanmingcheng'){
            this.ruleForm.fangyuanmingcheng = obj[o];
            continue;
          }
                    if(o=='mianji'){
            this.ruleForm.mianji = obj[o];
            continue;
          }
                    if(o=='zhuangtai'){
            this.ruleForm.zhuangtai = obj[o];
            continue;
          }
                    if(o=='geju'){
            this.ruleForm.geju = obj[o];
            continue;
          }
                    if(o=='jiage'){
            this.ruleForm.jiage = obj[o];
            continue;
          }
                    if(o=='chengshi'){
            this.ruleForm.chengshi = obj[o];
            continue;
          }
                    if(o=='tupian'){
            this.ruleForm.tupian = obj[o];
            continue;
          }
                    if(o=='jiaotongfangbianchengdu'){
            this.ruleForm.jiaotongfangbianchengdu = obj[o];
            continue;
          }
                    if(o=='dizhi'){
            this.ruleForm.dizhi = obj[o];
            continue;
          }
                    if(o=='xiangqing'){
            this.ruleForm.xiangqing = obj[o];
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
                    if(o=='fabushijian'){
            this.ruleForm.fabushijian = obj[o];
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
                                                                                                this.zhuangtaiOptions = "待租,已出租".split(',')
                                                                                                                this.jiaotongfangbianchengduOptions = "非常方便,比较方便,一般,非常不方便,不是很方便".split(',')
                                                                                                                                        },
                                                                                                                                // 多级联动参数
                                                                                                                                                                  info(id) {
      this.$http({
        url: `fangyuanxinxi/info/${id}`,
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
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                                                                                                                                                                                                                                                                                                                  this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `fangyuanxinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.fangyuanxinxiCrossAddOrUpdateFlag = false;
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
      this.parent.fangyuanxinxiCrossAddOrUpdateFlag = false;
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
