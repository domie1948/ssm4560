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
        <el-form-item  v-if="type!='info'"  label="用户名" prop="yonghuming">
          <el-input v-model="ruleForm.yonghuming" 
              placeholder="用户名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.yonghuming" label="用户名" prop="yonghuming">
              <el-input v-model="ruleForm.yonghuming" 
                placeholder="用户名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="用户姓名" prop="yonghuxingming">
          <el-input v-model="ruleForm.yonghuxingming" 
              placeholder="用户姓名" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.yonghuxingming" label="用户姓名" prop="yonghuxingming">
              <el-input v-model="ruleForm.yonghuxingming" 
                placeholder="用户姓名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="身份证" prop="shenfenzheng">
          <el-input v-model="ruleForm.shenfenzheng" 
              placeholder="身份证" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shenfenzheng" label="身份证" prop="shenfenzheng">
              <el-input v-model="ruleForm.shenfenzheng" 
                placeholder="身份证" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="近期居住地址" prop="jinqijuzhudizhi">
          <el-input v-model="ruleForm.jinqijuzhudizhi" 
              placeholder="近期居住地址" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.jinqijuzhudizhi" label="近期居住地址" prop="jinqijuzhudizhi">
              <el-input v-model="ruleForm.jinqijuzhudizhi" 
                placeholder="近期居住地址" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'"  label="个人体温情况" prop="gerentiwenqingkuang">
          <el-select v-model="ruleForm.gerentiwenqingkuang" placeholder="请选择个人体温情况">
            <el-option
                v-for="(item,index) in gerentiwenqingkuangOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.gerentiwenqingkuang" label="个人体温情况" prop="gerentiwenqingkuang">
              <el-input v-model="ruleForm.gerentiwenqingkuang" 
                placeholder="个人体温情况" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'"  label="十四天内曾居住或前往疫情高发地" prop="shisitianneicengjuzhuhuoqianwangyiqinggaofadi">
          <el-select v-model="ruleForm.shisitianneicengjuzhuhuoqianwangyiqinggaofadi" placeholder="请选择十四天内曾居住或前往疫情高发地">
            <el-option
                v-for="(item,index) in shisitianneicengjuzhuhuoqianwangyiqinggaofadiOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shisitianneicengjuzhuhuoqianwangyiqinggaofadi" label="十四天内曾居住或前往疫情高发地" prop="shisitianneicengjuzhuhuoqianwangyiqinggaofadi">
              <el-input v-model="ruleForm.shisitianneicengjuzhuhuoqianwangyiqinggaofadi" 
                placeholder="十四天内曾居住或前往疫情高发地" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'"  label="两周内有与确诊患者接触" prop="liangzhouneiyouyuquezhenhuanzhejiechu">
          <el-select v-model="ruleForm.liangzhouneiyouyuquezhenhuanzhejiechu" placeholder="请选择两周内有与确诊患者接触">
            <el-option
                v-for="(item,index) in liangzhouneiyouyuquezhenhuanzhejiechuOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.liangzhouneiyouyuquezhenhuanzhejiechu" label="两周内有与确诊患者接触" prop="liangzhouneiyouyuquezhenhuanzhejiechu">
              <el-input v-model="ruleForm.liangzhouneiyouyuquezhenhuanzhejiechu" 
                placeholder="两周内有与确诊患者接触" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'"  label="出现不适症状" prop="chuxianbushizhengzhuang">
          <el-select v-model="ruleForm.chuxianbushizhengzhuang" placeholder="请选择出现不适症状">
            <el-option
                v-for="(item,index) in chuxianbushizhengzhuangOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.chuxianbushizhengzhuang" label="出现不适症状" prop="chuxianbushizhengzhuang">
              <el-input v-model="ruleForm.chuxianbushizhengzhuang" 
                placeholder="出现不适症状" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'"  label="一月内是否有国外或省外旅游史" prop="yiyueneishifouyouguowaihuoshengwailvyoushi">
          <el-select v-model="ruleForm.yiyueneishifouyouguowaihuoshengwailvyoushi" placeholder="请选择一月内是否有国外或省外旅游史">
            <el-option
                v-for="(item,index) in yiyueneishifouyouguowaihuoshengwailvyoushiOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.yiyueneishifouyouguowaihuoshengwailvyoushi" label="一月内是否有国外或省外旅游史" prop="yiyueneishifouyouguowaihuoshengwailvyoushi">
              <el-input v-model="ruleForm.yiyueneishifouyouguowaihuoshengwailvyoushi" 
                placeholder="一月内是否有国外或省外旅游史" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item  v-if="type!='info'"  label="备注" prop="beizhu">
          <el-input v-model="ruleForm.beizhu" 
              placeholder="备注" clearable></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.beizhu" label="备注" prop="beizhu">
              <el-input v-model="ruleForm.beizhu" 
                placeholder="备注" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                        <el-col :span="12">
        <el-form-item v-if="type!='info'" label="登记时间" prop="dengjishijian">
            <el-date-picker
                value-format="yyyy-MM-dd HH:mm:ss"
                v-model="ruleForm.dengjishijian" 
                type="datetime"
                placeholder="登记时间">
            </el-date-picker>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.dengjishijian" label="登记时间" prop="dengjishijian">
              <el-input v-model="ruleForm.dengjishijian" 
                placeholder="登记时间" readonly></el-input>
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
                        yonghuming: '',
                                yonghuxingming: '',
                                shenfenzheng: '',
                                jinqijuzhudizhi: '',
                                gerentiwenqingkuang: '',
                                shisitianneicengjuzhuhuoqianwangyiqinggaofadi: '',
                                liangzhouneiyouyuquezhenhuanzhejiechu: '',
                                chuxianbushizhengzhuang: '',
                                yiyueneishifouyouguowaihuoshengwailvyoushi: '',
                                beizhu: '',
                                dengjishijian: '',
                                tupian: '',
                                userid: '',
                      },
                                                                                gerentiwenqingkuangOptions: [],
                                shisitianneicengjuzhuhuoqianwangyiqinggaofadiOptions: [],
                                liangzhouneiyouyuquezhenhuanzhejiechuOptions: [],
                                chuxianbushizhengzhuangOptions: [],
                                yiyueneishifouyouguowaihuoshengwailvyoushiOptions: [],
                                                                            rules: {
                  yonghuming: [
                                                                                              ],
                  yonghuxingming: [
                                                                                              ],
                  shenfenzheng: [
                                                                                              ],
                  jinqijuzhudizhi: [
                                                                                              ],
                  gerentiwenqingkuang: [
                                                                                              ],
                  shisitianneicengjuzhuhuoqianwangyiqinggaofadi: [
                                                                                              ],
                  liangzhouneiyouyuquezhenhuanzhejiechu: [
                                                                                              ],
                  chuxianbushizhengzhuang: [
                                                                                              ],
                  yiyueneishifouyouguowaihuoshengwailvyoushi: [
                                                                                              ],
                  beizhu: [
                                                                                              ],
                  dengjishijian: [
                                                                                              ],
                  tupian: [
                                                                                              ],
                  userid: [
                            { required: true, message: '用户id不能为空', trigger: 'blur' },
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
                    if(o=='yonghuming'){
            this.ruleForm.yonghuming = obj[o];
            continue;
          }
                    if(o=='yonghuxingming'){
            this.ruleForm.yonghuxingming = obj[o];
            continue;
          }
                    if(o=='shenfenzheng'){
            this.ruleForm.shenfenzheng = obj[o];
            continue;
          }
                    if(o=='jinqijuzhudizhi'){
            this.ruleForm.jinqijuzhudizhi = obj[o];
            continue;
          }
                    if(o=='gerentiwenqingkuang'){
            this.ruleForm.gerentiwenqingkuang = obj[o];
            continue;
          }
                    if(o=='shisitianneicengjuzhuhuoqianwangyiqinggaofadi'){
            this.ruleForm.shisitianneicengjuzhuhuoqianwangyiqinggaofadi = obj[o];
            continue;
          }
                    if(o=='liangzhouneiyouyuquezhenhuanzhejiechu'){
            this.ruleForm.liangzhouneiyouyuquezhenhuanzhejiechu = obj[o];
            continue;
          }
                    if(o=='chuxianbushizhengzhuang'){
            this.ruleForm.chuxianbushizhengzhuang = obj[o];
            continue;
          }
                    if(o=='yiyueneishifouyouguowaihuoshengwailvyoushi'){
            this.ruleForm.yiyueneishifouyouguowaihuoshengwailvyoushi = obj[o];
            continue;
          }
                    if(o=='beizhu'){
            this.ruleForm.beizhu = obj[o];
            continue;
          }
                    if(o=='dengjishijian'){
            this.ruleForm.dengjishijian = obj[o];
            continue;
          }
                    if(o=='tupian'){
            this.ruleForm.tupian = obj[o];
            continue;
          }
                    if(o=='userid'){
            this.ruleForm.userid = obj[o];
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
                                    this.ruleForm.yonghuming = json.yonghuming
                                                this.ruleForm.yonghuxingming = json.yonghuxingming
                                                this.ruleForm.shenfenzheng = json.shenfenzheng
                                                                                                                                                                                                                                                          } else {
          this.$message.error(data.msg);
        }
      });
                                                                                                                  this.gerentiwenqingkuangOptions = "正常37.3度以下,低烧37.3至37.9度,中烧38至39度,高烧39度以上".split(',')
                                        this.shisitianneicengjuzhuhuoqianwangyiqinggaofadiOptions = "是,否".split(',')
                                        this.liangzhouneiyouyuquezhenhuanzhejiechuOptions = "是,否".split(',')
                                        this.chuxianbushizhengzhuangOptions = "是,否".split(',')
                                        this.yiyueneishifouyouguowaihuoshengwailvyoushiOptions = "是,否".split(',')
                                                                                                    },
                                                                                                                // 多级联动参数
                                                                                                                                              info(id) {
      this.$http({
        url: `gerenjiankangdaka/info/${id}`,
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
                                                                                                                                                                                                                                                                              this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `gerenjiankangdaka/${!this.ruleForm.id ? "save" : "update"}`,
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
                  this.parent.gerenjiankangdakaCrossAddOrUpdateFlag = false;
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
      this.parent.gerenjiankangdakaCrossAddOrUpdateFlag = false;
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
