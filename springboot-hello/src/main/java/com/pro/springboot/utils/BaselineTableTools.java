package com.pro.springboot.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;

public class BaselineTableTools {
    static final String TPL_ENGINE = "!function(){\"use strict\";var u,d={name:\"doT\",version:\"1.1.1\",templateSettings:{evaluate:/\\{\\{([\\s\\S]+?(\\}?)+)\\}\\}/g,interpolate:/\\{\\{=([\\s\\S]+?)\\}\\}/g,encode:/\\{\\{!([\\s\\S]+?)\\}\\}/g,use:/\\{\\{#([\\s\\S]+?)\\}\\}/g,useParams:/(^|[^\\w$])def(?:\\.|\\[[\\'\\\"])([\\w$\\.]+)(?:[\\'\\\"]\\])?\\s*\\:\\s*([\\w$\\.]+|\\\"[^\\\"]+\\\"|\\'[^\\']+\\'|\\{[^\\}]+\\})/g,define:/\\{\\{##\\s*([\\w\\.$]+)\\s*(\\:|=)([\\s\\S]+?)#\\}\\}/g,defineParams:/^\\s*([\\w$]+):([\\s\\S]+)/,conditional:/\\{\\{\\?(\\?)?\\s*([\\s\\S]*?)\\s*\\}\\}/g,iterate:/\\{\\{~\\s*(?:\\}\\}|([\\s\\S]+?)\\s*\\:\\s*([\\w$]+)\\s*(?:\\:\\s*([\\w$]+))?\\s*\\}\\})/g,varname:\"it\",strip:!0,append:!0,selfcontained:!1,doNotSkipEncoded:!1},template:void 0,compile:void 0,log:!0};d.encodeHTMLSource=function(e){var n={\"&\":\"&#38;\",\"<\":\"&#60;\",\">\":\"&#62;\",'\"':\"&#34;\",\"'\":\"&#39;\",\"/\":\"&#47;\"},t=e?/[&<>\"'\\/]/g:/&(?!#?\\w+;)|<|>|\"|'|\\//g;return function(e){return e?e.toString().replace(t,function(e){return n[e]||e}):\"\"}},u=function(){return this||(0,eval)(\"this\")}(),\"undefined\"!=typeof module&&module.exports?module.exports=d:\"function\"==typeof define&&define.amd?define(function(){return d}):u.doT=d;var s={append:{start:\"'+(\",end:\")+'\",startencode:\"'+encodeHTML(\"},split:{start:\"';out+=(\",end:\");out+='\",startencode:\"';out+=encodeHTML(\"}},p=/$^/;function l(e){return e.replace(/\\\\('|\\\\)/g,\"$1\").replace(/[\\r\\t\\n]/g,\" \")}d.template=function(e,n,t){var r,o,a=(n=n||d.templateSettings).append?s.append:s.split,c=0,i=n.use||n.define?function r(o,e,a){return(\"string\"==typeof e?e:e.toString()).replace(o.define||p,function(e,r,n,t){return 0===r.indexOf(\"def.\")&&(r=r.substring(4)),r in a||(\":\"===n?(o.defineParams&&t.replace(o.defineParams,function(e,n,t){a[r]={arg:n,text:t}}),r in a||(a[r]=t)):new Function(\"def\",\"def['\"+r+\"']=\"+t)(a)),\"\"}).replace(o.use||p,function(e,n){o.useParams&&(n=n.replace(o.useParams,function(e,n,t,r){if(a[t]&&a[t].arg&&r){var o=(t+\":\"+r).replace(/'|\\\\/g,\"_\");return a.__exp=a.__exp||{},a.__exp[o]=a[t].text.replace(new RegExp(\"(^|[^\\\\w$])\"+a[t].arg+\"([^\\\\w$])\",\"g\"),\"$1\"+r+\"$2\"),n+\"def.__exp['\"+o+\"']\"}}));var t=new Function(\"def\",\"return \"+n)(a);return t?r(o,t,a):t})}(n,e,t||{}):e;i=(\"var out='\"+(n.strip?i.replace(/(^|\\r|\\n)\\t* +| +\\t*(\\r|\\n|$)/g,\" \").replace(/\\r|\\n|\\t|\\/\\*[\\s\\S]*?\\*\\//g,\"\"):i).replace(/'|\\\\/g,\"\\\\$&\").replace(n.interpolate||p,function(e,n){return a.start+l(n)+a.end}).replace(n.encode||p,function(e,n){return r=!0,a.startencode+l(n)+a.end}).replace(n.conditional||p,function(e,n,t){return n?t?\"';}else if(\"+l(t)+\"){out+='\":\"';}else{out+='\":t?\"';if(\"+l(t)+\"){out+='\":\"';}out+='\"}).replace(n.iterate||p,function(e,n,t,r){return n?(c+=1,o=r||\"i\"+c,n=l(n),\"';var arr\"+c+\"=\"+n+\";if(arr\"+c+\"){var \"+t+\",\"+o+\"=-1,l\"+c+\"=arr\"+c+\".length-1;while(\"+o+\"<l\"+c+\"){\"+t+\"=arr\"+c+\"[\"+o+\"+=1];out+='\"):\"';} } out+='\"}).replace(n.evaluate||p,function(e,n){return\"';\"+l(n)+\"out+='\"})+\"';return out;\").replace(/\\n/g,\"\\\\n\").replace(/\\t/g,\"\\\\t\").replace(/\\r/g,\"\\\\r\").replace(/(\\s|;|\\}|^|\\{)out\\+='';/g,\"$1\").replace(/\\+''/g,\"\"),r&&(n.selfcontained||!u||u._encodeHTML||(u._encodeHTML=d.encodeHTMLSource(n.doNotSkipEncoded)),i=\"var encodeHTML = typeof _encodeHTML !== 'undefined' ? _encodeHTML : (\"+d.encodeHTMLSource.toString()+\"(\"+(n.doNotSkipEncoded||\"\")+\"));\"+i);try{return new Function(n.varname,i)}catch(e){throw\"undefined\"!=typeof console&&console.log(\"Could not create a template function: \"+i),e}},d.compile=function(e,n){return d.template(e,null,n)}}();\n" +
            "\n" +
            "var renderTemplate=function(tpl,data){\n" +
            "    return (doT.template(tpl))(data);\n" +
            "};";
    static final String TPL_STRING = "{\n" +
            "  \"idCard\": \"{{=it.idCard}}\",\n" +
            "  \"table1\": {\n" +
            "    \"name\": \"人口学资料\",\n" +
            "    \"content\": {\n" +
            "      \"title\": \"人口学资料\",\n" +
            "      \"data\": [\n" +
            "        {\n" +
            "          \"sort\": 1,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"填表日期\",\n" +
            "            \"code\": \"createdate\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"{{=it.createdate}}\",\n" +
            "            \"code\": \"createdate\"\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"sort\": 2,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"真实姓名\",\n" +
            "            \"code\": \"name\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"{{=it.name}}\",\n" +
            "            \"code\": \"name\"\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"sort\": 3,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"性别\",\n" +
            "            \"code\": \"sexcode\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"{{=it.sexcode}}\",\n" +
            "            \"code\": \"sexcode\"\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"sort\": 4,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"出生日期\",\n" +
            "            \"code\": \"birthday\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"{{=it.birthday}}\",\n" +
            "            \"code\": \"birthday\"\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"sort\": 5,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"年龄\",\n" +
            "            \"code\": \"age\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"{{=it.age}}\",\n" +
            "            \"code\": \"age\"\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"sort\": 5,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"文化程度\",\n" +
            "            \"code\": \"education\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"{{=it.education}}\",\n" +
            "            \"code\": \"education\"\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"sort\": 6,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"民族\",\n" +
            "            \"code\": \"nation\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"{{=it.nation}}\",\n" +
            "            \"code\": \"nation\"\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"sort\": 7,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"常住住址\",\n" +
            "            \"code\": \"address\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"{{=it.address}}\",\n" +
            "            \"code\": \"address\"\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"sort\": 8,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"手机\",\n" +
            "            \"code\": \"phone\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"{{=it.phone}}\",\n" +
            "            \"code\": \"phone\"\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"sort\": 9,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"紧急联系人\",\n" +
            "            \"code\": \"contactpeople\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"{{=it.contactpeople}}\",\n" +
            "            \"code\": \"contactpeople\"\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"sort\": 10,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"紧急联系人电话\",\n" +
            "            \"code\": \"iecphone\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"{{=it.iecphone}}\",\n" +
            "            \"code\": \"iecphone\"\n" +
            "          }\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  },\n" +
            "  \"table2\": {\n" +
            "    \"name\": \"心血管病危险因素\",\n" +
            "    \"content\": {\n" +
            "      \"title\": \"心血管病危险因素\",\n" +
            "      \"data\": [\n" +
            "        {\n" +
            "          \"sort\": 1,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"、\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"病史\",\n" +
            "            \"code\": \"diseasehistory\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"\",\n" +
            "            \"code\": \"diseasehistory\"\n" +
            "          },\n" +
            "          \"child\": [\n" +
            "            {\n" +
            "              \"sort\": 1,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"高血压\",\n" +
            "                \"code\": \"GXY\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.GXY}}\",\n" +
            "                \"code\": \"GXY\"\n" +
            "              }\n" +
            "            {{if( it.GXY === '有'){ }}\n" +
            "              ,\"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"高血压诊断时间\",\n" +
            "                    \"code\": \"GXYZDSJ\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"2020-01-01\",\n" +
            "                    \"code\": \"GXYZDSJ\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 2,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"是否服用降压药\",\n" +
            "                    \"code\": \"SFFYJYY\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.SFFYJYY}}\",\n" +
            "                    \"code\": \"SFFYJYY\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 3,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"开始用药时间\",\n" +
            "                    \"code\": \"KSYYSJ\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.KSYYSJ}}\",\n" +
            "                    \"code\": \"KSYYSJ\"\n" +
            "                  }\n" +
            "                }\n" +
            "              ]\n" +
            "            {{ } }}\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 2,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"糖尿病\",\n" +
            "                \"code\": \"TNB\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.TNB}}\",\n" +
            "                \"code\": \"TNB\"\n" +
            "              }\n" +
            "            {{if(it.TNB=='有'){ }}\n" +
            "              ,\"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"诊断时间\",\n" +
            "                    \"code\": \"TNBZDSJ\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.TNBZDSJ}}\",\n" +
            "                    \"code\": \"TNBZDSJ\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 2,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"是否服用（注射）降糖药\",\n" +
            "                    \"code\": \"SFFYJTY\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.SFFYJTY}}\",\n" +
            "                    \"code\": \"SFFYJTY\"\n" +
            "                  }\n" +
            "                }\n" +
            "              ]\n" +
            "            {{ } }}\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 3,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"高脂血症\",\n" +
            "                \"code\": \"GZXZ\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.GZXZ}}\",\n" +
            "                \"code\": \"GZXZ\"\n" +
            "              }\n" +
            "            {{if(it.GZXZ=='有') { }}\n" +
            "              ,\"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"诊断时间\",\n" +
            "                    \"code\": \"GZXZZDSJ\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.GZXZZDSJ}}\",\n" +
            "                    \"code\": \"GZXZZDSJ\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 2,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"是否用药\",\n" +
            "                    \"code\": \"GZXZSFYY\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.GZXZSFYY}}\",\n" +
            "                    \"code\": \"GZXZSFYY\"\n" +
            "                  }\n" +
            "                }\n" +
            "              ]\n" +
            "            {{ } }}\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 4,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"既往有无冠心病\",\n" +
            "                \"code\": \"JWYWGXB\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.JWYWGXB}}\",\n" +
            "                \"code\": \"JWYWGXB\"\n" +
            "              }\n" +
            "            {{if(it.JWYWGXB=='有') { }}\n" +
            "              ,\"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"诊断时间\",\n" +
            "                    \"code\": \"GXBZDSJ\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"2020-01-01\",\n" +
            "                    \"code\": \"GXBZDSJ\"\n" +
            "                  }\n" +
            "                }\n" +
            "              ]\n" +
            "            {{ } }}\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 5,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"既往有无脑卒中\",\n" +
            "                \"code\": \"JWYWNZZ\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.JWYWNZZ}}\",\n" +
            "                \"code\": \"JWYWNZZ\"\n" +
            "              }\n" +
            "             {{if(it.JWYWNZZ=='有'){ }}\n" +
            "              ,\"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"诊断时间\",\n" +
            "                    \"code\": \"NZZZDSJ\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"2020-01-01\",\n" +
            "                    \"code\": \"NZZZDSJ\"\n" +
            "                  }\n" +
            "                }\n" +
            "              ]\n" +
            "            {{ } }}\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 6,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"有无其他系统疾病（肝硬化、慢阻肺、肾功能不全等）\",\n" +
            "                \"code\": \"YWQTJB\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.YWQTJB}}\",\n" +
            "                \"code\": \"YWQTJB\"\n" +
            "              }\n" +
            "            {{if(it.YWQTJB=='有'){ }}\n" +
            "              ,\"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"具体疾病\",\n" +
            "                    \"code\": \"YWQTJBJT\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.YWQTJBJT}}\",\n" +
            "                    \"code\": \"YWQTJBJT\"\n" +
            "                  }\n" +
            "                }\n" +
            "              ]\n" +
            "            {{ } }}\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"sort\": 2,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"、\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"家族史（直系父母兄弟姐妹）\",\n" +
            "            \"code\": \"字段名\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"\",\n" +
            "            \"code\": \"\"\n" +
            "          },\n" +
            "          \"child\": [\n" +
            "            {\n" +
            "              \"sort\": 1,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"高血压家族史\",\n" +
            "                \"code\": \"GXYJZS\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.GXYJZS}}\",\n" +
            "                \"code\": \"GXYJZS\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 2,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"冠心病家族史\",\n" +
            "                \"code\": \"GXBJZS\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.GXBJZS}}\",\n" +
            "                \"code\": \"GXBJZS\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 3,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"糖尿病家族史\",\n" +
            "                \"code\": \"TNBJZS\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.TNBJZS}}\",\n" +
            "                \"code\": \"TNBJZS\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 4,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"脑中风家族史\",\n" +
            "                \"code\": \"NZZJZS\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.NZZJZS}}\",\n" +
            "                \"code\": \"NZZJZS\"\n" +
            "              }\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"sort\": 3,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"、\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"生活习惯\",\n" +
            "            \"code\": \"字段名\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"\",\n" +
            "            \"code\": \"\"\n" +
            "          },\n" +
            "          \"child\": [\n" +
            "            {\n" +
            "              \"sort\": 1,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"打鼾\",\n" +
            "                \"code\": \"DH\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.DH}}\",\n" +
            "                \"code\": \"DH\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 2,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"是否有睡眠呼吸暂停\",\n" +
            "                \"code\": \"SFYSMHXZT\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.SFYSMHXZT}}\",\n" +
            "                \"code\": \"SFYSMHXZT\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 3,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"吸烟情况\",\n" +
            "                \"code\": \"XYZK\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.XYZK}}\",\n" +
            "                \"code\": \"XYZK\"\n" +
            "              },\n" +
            "              \"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 2,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"开始吸烟年龄\",\n" +
            "                    \"code\": \"XYZKJYKSNL\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.XYZKJYKSNL}} 岁\",\n" +
            "                    \"code\": \"XYZKJYKSNL\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 2,\n" +
            "                  \"level\": 2,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"日吸烟量\",\n" +
            "                    \"code\": \"XYZKJYMTJZ\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.XYZKJYMTJZ}} 支/日\",\n" +
            "                    \"code\": \"XYZKJYMTJZ\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 3,\n" +
            "                  \"level\": 2,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"戒烟年龄\",\n" +
            "                    \"code\": \"XYZKJYNL\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.XYZKJYNL}} 岁\",\n" +
            "                    \"code\": \"XYZKJYNL\"\n" +
            "                  }\n" +
            "                }\n" +
            "              ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 4,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"饮酒情况\",\n" +
            "                \"code\": \"YJQK\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.YJQK}}\",\n" +
            "                \"code\": \"YJQK\"\n" +
            "              },\n" +
            "              \"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 2,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"日饮酒量\",\n" +
            "                    \"code\": \"YJQKORMTJL\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.YJQKORMTJL}} 两/天\",\n" +
            "                    \"code\": \"YJQKORMTJL\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 2,\n" +
            "                  \"level\": 2,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"是否戒酒\",\n" +
            "                    \"code\": \"SFJJ\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.SFJJ}}\",\n" +
            "                    \"code\": \"SFJJ\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 3,\n" +
            "                  \"level\": 2,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"戒酒年龄\",\n" +
            "                    \"code\": \"SFJJYJJJJNL\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.SFJJYJJJJNL}} 岁\",\n" +
            "                    \"code\": \"SFJJYJJJJNL\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 4,\n" +
            "                  \"level\": 2,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"开始饮酒年龄\",\n" +
            "                    \"code\": \"KSYJNL\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.KSYJNL}} 岁\",\n" +
            "                    \"code\": \"KSYJNL\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 5,\n" +
            "                  \"level\": 2,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"近一年内是否曾醉酒\",\n" +
            "                    \"code\": \"JYNSFJJ\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.JYNSFJJ}}\",\n" +
            "                    \"code\": \"JYNSFJJ\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 6,\n" +
            "                  \"level\": 2,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"饮酒种类\",\n" +
            "                    \"code\": \"YJZL\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.YJZL}}\",\n" +
            "                    \"code\": \"YJZL\"\n" +
            "                  }\n" +
            "                }\n" +
            "              ]\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  },\n" +
            "  \"table3\": {\n" +
            "    \"name\": \"体格检查\",\n" +
            "    \"content\": {\n" +
            "      \"title\": \"体格检查\",\n" +
            "      \"data\": [\n" +
            "        {\n" +
            "          \"sort\": 1,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"、\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"基本体征\",\n" +
            "            \"code\": \"字段名\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"\",\n" +
            "            \"code\": \"\"\n" +
            "          },\n" +
            "          \"child\": [\n" +
            "            {\n" +
            "              \"sort\": 1,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"身高\",\n" +
            "                \"code\": \"SG\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.SG}} cm\",\n" +
            "                \"code\": \"SG\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 2,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"体重\",\n" +
            "                \"code\": \"TZ\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.TZ}} kg\",\n" +
            "                \"code\": \"TZ\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 3,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"体重指数（BMI）\",\n" +
            "                \"code\": \"TZZS\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.TZZS}} kg/m2\",\n" +
            "                \"code\": \"TZZS\"\n" +
            "              }\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"sort\": 2,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"、\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"诊室血压\",\n" +
            "            \"code\": \"字段名\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"\",\n" +
            "            \"code\": \"\"\n" +
            "          },\n" +
            "          \"child\": [\n" +
            "            {\n" +
            "              \"sort\": 1,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"右上肢血压\",\n" +
            "                \"code\": \"字段名\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"\",\n" +
            "                \"code\": \"\"\n" +
            "              },\n" +
            "              \"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"第一次测量\",\n" +
            "                    \"code\": \"YSZDY\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.YSZDY}} mmHg\",\n" +
            "                    \"code\": \"YSZDY\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 2,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"第二次测量\",\n" +
            "                    \"code\": \"YSZDE\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.YSZDE}} mmHg\",\n" +
            "                    \"code\": \"YSZDE\"\n" +
            "                  }\n" +
            "                }\n" +
            "              ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 2,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"左上肢血压\",\n" +
            "                \"code\": \"字段名\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"\",\n" +
            "                \"code\": \"\"\n" +
            "              },\n" +
            "              \"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"第一次测量\",\n" +
            "                    \"code\": \"ZSZDY\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.ZSZDY}} mmHg\",\n" +
            "                    \"code\": \"ZSZDY\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 2,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"第二次测量\",\n" +
            "                    \"code\": \"ZSZDE\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.ZSZDE}} mmHg\",\n" +
            "                    \"code\": \"ZSZDE\"\n" +
            "                  }\n" +
            "                }\n" +
            "              ]\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 3,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"心率\",\n" +
            "                \"code\": \"XL\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.XL}}\",\n" +
            "                \"code\": \"XL\"\n" +
            "              }\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  },\n" +
            "  \"table4\": {\n" +
            "    \"name\": \"辅助检查\",\n" +
            "    \"content\": {\n" +
            "      \"title\": \"辅助检查\",\n" +
            "      \"data\": [\n" +
            "        {\n" +
            "          \"sort\": 1,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"、\",\n" +
            "          \"type\": \"click\",\n" +
            "          \"icon\": \"http://www.baidu.com\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"实验室检查\",\n" +
            "            \"code\": \"字段名\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"\",\n" +
            "            \"code\": \"\"\n" +
            "          },\n" +
            "          \"child\": [\n" +
            "            {\n" +
            "              \"sort\": 1,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"检测日期\",\n" +
            "                \"code\": \"FJJCSJ\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.FJJCSJ}}\",\n" +
            "                \"code\": \"FJJCSJ\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 2,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"血钾(K)\",\n" +
            "                \"code\": \"XJ\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.XJ}} mmol/L\",\n" +
            "                \"code\": \"XJ\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 3,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"血钠(Na)\",\n" +
            "                \"code\": \"XN\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.XN}} mmol/L\",\n" +
            "                \"code\": \"XN\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 4,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"丙氨酸氨基转移酶(ALT)\",\n" +
            "                \"code\": \"BASAJZYM\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.BASAJZYM}} U/L\",\n" +
            "                \"code\": \"BASAJZYM\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 5,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"天门冬氨酸氨基转移酶(AST)\",\n" +
            "                \"code\": \"TMDASAJZYM\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.TMDASAJZYM}} U/L\",\n" +
            "                \"code\": \"TMDASAJZYM\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 6,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"血尿素氮(BUN)\",\n" +
            "                \"code\": \"XNSD\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.XNSD}} mmol/L\",\n" +
            "                \"code\": \"XNSD\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 7,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"血肌酐(CREA)\",\n" +
            "                \"code\": \"XJG\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.XJG}} μmol/L\",\n" +
            "                \"code\": \"XJG\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 8,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"血尿酸(UA)\",\n" +
            "                \"code\": \"XNS\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.XNS}} mmol/L\",\n" +
            "                \"code\": \"XNS\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 9,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"肾小球滤过率（eGFR）\",\n" +
            "                \"code\": \"SXQLGL\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.SXQLGL}}  ml/min/1.73m2\",\n" +
            "                \"code\": \"SXQLGL\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 10,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"总胆固醇(TC)\",\n" +
            "                \"code\": \"ZDGC\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.ZDGC}} mmol/L\",\n" +
            "                \"code\": \"ZDGC\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 11,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"甘油三酯(TG)\",\n" +
            "                \"code\": \"GYSZ\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.GYSZ}} mmol/L\",\n" +
            "                \"code\": \"GYSZ\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 12,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"低密度脂蛋白胆固醇(LDL-C)\",\n" +
            "                \"code\": \"DMDZDBDGC\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.DMDZDBDGC}} mmol/L\",\n" +
            "                \"code\": \"DMDZDBDGC\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 13,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"高密度脂蛋白胆固醇(HLD-C)\",\n" +
            "                \"code\": \"GMDZDBDGC\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.GMDZDBDGC}} mmol/L\",\n" +
            "                \"code\": \"GMDZDBDGC\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 14,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"空腹血糖(FBG)\",\n" +
            "                \"code\": \"KFXT\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.KFXT}} mmol/L\",\n" +
            "                \"code\": \"KFXT\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 15,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"糖化血红蛋白(HbA1c)\",\n" +
            "                \"code\": \"THXHDB\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.THXHDB}} %\",\n" +
            "                \"code\": \"THXHDB\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 16,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"同型半胱氨酸(Hcy)\",\n" +
            "                \"code\": \"TXBGAS\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.TXBGAS}} μmol/L\",\n" +
            "                \"code\": \"TXBGAS\"\n" +
            "              }\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"sort\": 2,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"、\",\n" +
            "          \"type\": \"click\",\n" +
            "          \"icon\": \"http://www.baidu.com\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"心电图（ECG)\",\n" +
            "            \"code\": \"字段名\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"\",\n" +
            "            \"code\": \"\"\n" +
            "          },\n" +
            "          \"child\": [\n" +
            "            {\n" +
            "              \"sort\": 1,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"心电图有无异常\",\n" +
            "                \"code\": \"XDT\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.XDT}}\",\n" +
            "                \"code\": \"XDT\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 2,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"textarea\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"异常描述\",\n" +
            "                \"code\": \"XDTYC\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.XDTYC}}\",\n" +
            "                \"code\": \"XDTYC\"\n" +
            "              }\n" +
            "            }\n" +
            "          ]\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  },\n" +
            "  \"table5\": {\n" +
            "    \"name\": \"患者目前治疗方案\",\n" +
            "    \"content\": {\n" +
            "      \"title\": \"患者目前治疗方案\",\n" +
            "      \"data\": [\n" +
            "        {\n" +
            "          \"sort\": 1,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"、\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"是否采取控制饮食\",\n" +
            "            \"code\": \"KZYS\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"{{=it.KZYS}}\",\n" +
            "            \"code\": \"KZYS\"\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"sort\": 2,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"、\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"是否采运动措施\",\n" +
            "            \"code\": \"YDCS\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"{{=it.YDCS}}\",\n" +
            "            \"code\": \"YDCS\"\n" +
            "          }\n" +
            "        },\n" +
            "        {\n" +
            "          \"sort\": 3,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"、\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"是否用药\",\n" +
            "            \"code\": \"SFYY+SFYYYES\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"{{=it.SFYY}},{{=it.SFYYYES}}\",\n" +
            "            \"code\": \"SFYY+SFYYYES\"\n" +
            "          }\n" +
            "        {{if(it.SFYY=='是') { }}\n" +
            "          ,\"child\": [\n" +
            "            {\n" +
            "              \"sort\": 1,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"用药频率\",\n" +
            "                \"code\": \"JDFY\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.JDFY}} 次周\",\n" +
            "                \"code\": \"JDFY\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 1,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"目前用药情况\",\n" +
            "                \"code\": \"字段名\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"\",\n" +
            "                \"code\": \"\"\n" +
            "              },\n" +
            "              \"child\": [\n" +
            "                {{~it.DRUGS:DRUG:index}}\n" +
            "                  {{if(index!=0){ }},{{ } }}\n" +
            "                  {\n" +
            "                    \"sort\": {{=index+1}},\n" +
            "                    \"level\": 3,\n" +
            "                    \"prefix\": \")\",\n" +
            "                    \"type\": \"text\",\n" +
            "                    \"key\": {\n" +
            "                      \"name\": \"药品名称\",\n" +
            "                      \"code\": \"YWMC\"\n" +
            "                    },\n" +
            "                    \"value\": {\n" +
            "                      \"name\": \"{{=DRUG.YWMC}}\",\n" +
            "                      \"code\": \"YWMC\"\n" +
            "                    },\n" +
            "                    \"child\": [\n" +
            "                      {\n" +
            "                        \"sort\": 1,\n" +
            "                        \"level\": 4,\n" +
            "                        \"prefix\": \"\",\n" +
            "                        \"type\": \"text\",\n" +
            "                        \"key\": {\n" +
            "                          \"name\": \"用药分类\",\n" +
            "                          \"code\": \"YPFL\"\n" +
            "                        },\n" +
            "                        \"value\": {\n" +
            "                          \"name\": \"{{=DRUG.YPFL}}\",\n" +
            "                          \"code\": \"YPFL\"\n" +
            "                        }\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"sort\": 2,\n" +
            "                        \"level\": 4,\n" +
            "                        \"prefix\": \"\",\n" +
            "                        \"type\": \"text\",\n" +
            "                        \"key\": {\n" +
            "                          \"name\": \"给药方法\",\n" +
            "                          \"code\": \"YWYF\"\n" +
            "                        },\n" +
            "                        \"value\": {\n" +
            "                          \"name\": \"{{=DRUG.YWYF}}\",\n" +
            "                          \"code\": \"YWYF\"\n" +
            "                        }\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"sort\": 3,\n" +
            "                        \"level\": 4,\n" +
            "                        \"prefix\": \"\",\n" +
            "                        \"type\": \"text\",\n" +
            "                        \"key\": {\n" +
            "                          \"name\": \"用量\",\n" +
            "                          \"code\": \"YWJL\"\n" +
            "                        },\n" +
            "                        \"value\": {\n" +
            "                          \"name\": \"{{=DRUG.YWJL}} mg/天\",\n" +
            "                          \"code\": \"YWJL\"\n" +
            "                        }\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"sort\": 4,\n" +
            "                        \"level\": 4,\n" +
            "                        \"prefix\": \"\",\n" +
            "                        \"type\": \"text\",\n" +
            "                        \"key\": {\n" +
            "                          \"name\": \"用药时间\",\n" +
            "                          \"code\": \"YWSJ\"\n" +
            "                        },\n" +
            "                        \"value\": {\n" +
            "                          \"name\": \"{{=DRUG.YWSJ}}\",\n" +
            "                          \"code\": \"YWSJ\"\n" +
            "                        }\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"sort\": 5,\n" +
            "                        \"level\": 4,\n" +
            "                        \"prefix\": \"\",\n" +
            "                        \"type\": \"text\",\n" +
            "                        \"key\": {\n" +
            "                          \"name\": \"服药依从性\",\n" +
            "                          \"code\": \"YWYCX\"\n" +
            "                        },\n" +
            "                        \"value\": {\n" +
            "                          \"name\": \"{{=DRUG.YWYCX}}\",\n" +
            "                          \"code\": \"YWYCX\"\n" +
            "                        }\n" +
            "                      }\n" +
            "                    ]\n" +
            "                  }\n" +
            "                {{~}}\n" +
            "              ]\n" +
            "            }\n" +
            "          ]\n" +
            "        {{ } }}\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  },\n" +
            "  \"table6\": {\n" +
            "    \"name\": \"各类事件发生情况\",\n" +
            "    \"content\": {\n" +
            "      \"title\": \"各类事件发生情况\",\n" +
            "      \"data\": [\n" +
            "        {\n" +
            "          \"sort\": 1,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"、\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"心血管事件（近1年）\",\n" +
            "            \"code\": \"字段名\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"\",\n" +
            "            \"code\": \"\"\n" +
            "          },\n" +
            "          \"child\": [\n" +
            "            {\n" +
            "              \"sort\": 1,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"急性心肌梗死\",\n" +
            "                \"code\": \"JXXJGS+JXXJGSYES\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.JXXJGS}}  {{=it.JXXJGSYES}}\",\n" +
            "                \"code\": \"JXXJGS+JXXJGSYES\"\n" +
            "              }\n" +
            "            {{if(it.JXXJGS=='有') { }}\n" +
            "              ,\"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"发病日期\",\n" +
            "                    \"code\": \"JXXJGSFBRQ\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.JXXJGSFBRQ}}\",\n" +
            "                    \"code\": \"JXXJGSFBRQ\"\n" +
            "                  }\n" +
            "                }\n" +
            "              ]\n" +
            "            {{ } }}\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 2,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"不稳定心绞痛\",\n" +
            "                \"code\": \"BWDXJT+BWDXJTYES\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.BWDXJT}}  {{=it.BWDXJTYES}}\",\n" +
            "                \"code\": \"BWDXJT+BWDXJTYES\"\n" +
            "              }\n" +
            "            {{if(it.BWDXJT=='有') { }}\n" +
            "              ,\"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"发病日期\",\n" +
            "                    \"code\": \"BWDXJTFBRQ\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.BWDXJTFBRQ}}\",\n" +
            "                    \"code\": \"BWDXJTFBRQ\"\n" +
            "                  }\n" +
            "                }\n" +
            "              ]\n" +
            "            {{ } }}\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 3,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"心衰住院治疗\",\n" +
            "                \"code\": \"XSZYZL\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.XSZYZL}}\",\n" +
            "                \"code\": \"XSZYZL\"\n" +
            "              }\n" +
            "             {{if(it.XSZYZL=='有') { }}\n" +
            "              ,\"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"发病日期\",\n" +
            "                    \"code\": \"XSZYZLFBRQ\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.XSZYZLFBRQ}}\",\n" +
            "                    \"code\": \"XSZYZLFBRQ\"\n" +
            "                  }\n" +
            "                }\n" +
            "              ]\n" +
            "            {{ } }}\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 4,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"血运重建\",\n" +
            "                \"code\": \"XYCJ+XYCJRGY\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.XYCJ}} {{=it.XYCJRGY}}\",\n" +
            "                \"code\": \"XYCJ+XYCJRGY\"\n" +
            "              }\n" +
            "            {{if(it.XYCJ=='有') { }}\n" +
            "              ,\"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"发病日期\",\n" +
            "                    \"code\": \"XYCJRQ\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.XYCJRQ}}\",\n" +
            "                    \"code\": \"XYCJRQ\"\n" +
            "                  }\n" +
            "                }\n" +
            "              ]\n" +
            "            {{ } }}\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"sort\": 2,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"、\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"脑血管事件（近1年）\",\n" +
            "            \"code\": \"字段名\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"\",\n" +
            "            \"code\": \"\"\n" +
            "          },\n" +
            "          \"child\": [\n" +
            "            {\n" +
            "              \"sort\": 1,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"脑卒中\",\n" +
            "                \"code\": \"NZZ\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.NZZ}}\",\n" +
            "                \"code\": \"NZZ\"\n" +
            "              }\n" +
            "            {{if(it.NZZ=='有'){ }}\n" +
            "              ,\"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"发病日期\",\n" +
            "                    \"code\": \"NZZFBRQ\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.NZZFBRQ}}\",\n" +
            "                    \"code\": \"NZZFBRQ\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 2,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"是否住院\",\n" +
            "                    \"code\": \"NZZSFZY\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.NZZSFZY}}\",\n" +
            "                    \"code\": \"NZZSFZY\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 3,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"诊断依据（有无CT或核磁）\",\n" +
            "                    \"code\": \"NZZSFZYZDYJ\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.NZZSFZYZDYJ}}\",\n" +
            "                    \"code\": \"NZZSFZYZDYJ\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 4,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"脑卒中分类\",\n" +
            "                    \"code\": \"NZZFL\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.NZZFL}}\",\n" +
            "                    \"code\": \"NZZFL\"\n" +
            "                  }\n" +
            "                }\n" +
            "              ]\n" +
            "            {{ } }}\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"sort\": 3,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"、\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"疾病肿瘤史（近1年）\",\n" +
            "            \"code\": \"NLJBS\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"{{=it.NLJBS}}\",\n" +
            "            \"code\": \"NLJBS\"\n" +
            "          }\n" +
            "        {{if(it.NLJBS=='有') { }}\n" +
            "          ,\"child\": [\n" +
            "            {\n" +
            "              \"sort\": 1,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"疾病诊断\",\n" +
            "                \"code\": \"NLJBSJBZD\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.NLJBSJBZD}}\",\n" +
            "                \"code\": \"NLJBSJBZD\"\n" +
            "              },\n" +
            "              \"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"诊断日期\",\n" +
            "                    \"code\": \"NLJBSZDRQ\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.NLJBSZDRQ}}\",\n" +
            "                    \"code\": \"NLJBSZDRQ\"\n" +
            "                  }\n" +
            "                }\n" +
            "              ]\n" +
            "            }\n" +
            "          ]\n" +
            "        {{ } }}\n" +
            "        },\n" +
            "        {\n" +
            "          \"sort\": 4,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"、\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"不良事件记录（近1年）\",\n" +
            "            \"code\": \"BLSJJLJYN\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"{{=it.BLSJJLJYN}}\",\n" +
            "            \"code\": \"BLSJJLJYN\"\n" +
            "          }\n" +
            "        {{if(it.BLSJJLJYN=='有') { }}\n" +
            "          ,\"child\": [\n" +
            "          {{~it.BLSJS:BLSJ:index}}\n" +
            "          {{if(index!=0) { }},{{ } }}\n" +
            "            {\n" +
            "              \"sort\": {{=index+1}},\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"低血压\",\n" +
            "                \"code\": \"BLSJMC\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=BLSJ.BLSJMC}}\",\n" +
            "                \"code\": \"BLSJMC\"\n" +
            "              },\n" +
            "              \"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"起止日期\",\n" +
            "                    \"code\": \"BLSJFSSJ+BLSJJSSJ\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=BLSJ.BLSJFSSJ}}至{{=BLSJ.BLSJJSSJ}}\",\n" +
            "                    \"code\": \"BLSJFSSJ+BLSJJSSJ\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 2,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"严重程度\",\n" +
            "                    \"code\": \"BLSJYZCD\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=BLSJ.BLSJYZCD}}\",\n" +
            "                    \"code\": \"BLSJYZCD\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 2,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"是否间断发生\",\n" +
            "                    \"code\": \"BLSJSFJDFS\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=BLSJ.BLSJSFJDFS}}\",\n" +
            "                    \"code\": \"BLSJSFJDFS\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 3,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"是否调整药物研究剂量\",\n" +
            "                    \"code\": \"BLSJYWJL\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=BLSJ.BLSJYWJL}}\",\n" +
            "                    \"code\": \"BLSJYWJL\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 4,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"与降压药物关系\",\n" +
            "                    \"code\": \"BLSJJYYWGX\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=BLSJ.BLSJJYYWGX}}\",\n" +
            "                    \"code\": \"BLSJJYYWGX\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 5,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"转归\",\n" +
            "                    \"code\": \"BLSJZG\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=BLSJ.BLSJZG}}\",\n" +
            "                    \"code\": \"BLSJZG\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 6,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"处理\",\n" +
            "                    \"code\": \"BLSJCL\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=BLSJ.BLSJCL}}\",\n" +
            "                    \"code\": \"BLSJCL\"\n" +
            "                  }\n" +
            "                }\n" +
            "              ]\n" +
            "            }\n" +
            "          {{~}}\n" +
            "          ]\n" +
            "        {{ } }}\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  }\n" +
            "}";
    static Invocable invoke = null;

    static {
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("javascript");
            engine.eval(TPL_ENGINE);
            if (engine instanceof Invocable) {
                invoke = (Invocable) engine;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String reader(JSONObject data) {
        try {
            String c = (String) invoke.invokeFunction("renderTemplate", TPL_STRING, data);
            return c.replaceAll("null","");
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
        String c = BaselineTableTools.reader(getData());
//        System.out.println("模版引擎返回:" + c);
//        JSONObject result = JSON.parseObject(c);
//        System.out.println(JSON.toJSONString(result, false));
        System.out.println(c);
    }

    private static JSONObject getData() {
        String dataStr = "{\"idCard\":\"142636198802065315\",\"name\":\"蓝调\",\"sexcode\":\"男\",\"birthday\":\"1988-02-06\",\"age\":\"32\",\"education\":\"大学专科和专科学校\",\"nation\":\"汉族\",\"address\":\"北京市东城区地坛公园101号\",\"phone\":\"18511548631\",\"contactPeople\":\"蓝调\",\"iecPhone\":\"18511548631\",\"phrId\":\"\",\"empiId\":\"4e9db3957e764825b0804be429c44979\",\"fillingDate\":\"2020-08-07\",\"GXY\":\"无\",\"GXYZDSJ\":\"2020-08-07\",\"SFFYJYY\":\"\",\"KSYYSJ\":\"2020-08-07\",\"TNB\":\"有\",\"TNBZDSJ\":\"2020-08-07\",\"SFFYJTY\":\"\",\"GZXZ\":\"不详\",\"GZXZZDSJ\":\"2020-08-07\",\"GZXZSFYY\":\"\",\"JWYWGXB\":\"有\",\"GXBZDSJ\":\"2020-08-07\",\"JWYWNZZ\":\"有\",\"NZZZDSJ\":\"2020-08-07\",\"YWQTJB\":\"不详\",\"YWQTJBJT\":\"\",\"GXYJZS\":\"无\",\"GXBJZS\":\"无\",\"TNBJZS\":\"无\",\"NZZJZS\":\"无\",\"DH\":\"无\",\"SFYSMHXZT\":\"无\",\"XYZK\":\"吸烟\",\"XYZKJYKSNL\":\"\",\"XYZKJYMTJZ\":\"\",\"XYZKJYNL\":\"\",\"YJQK\":\"从不\",\"YJQKORMTJL\":\"\",\"SFJJ\":\"未戒酒\",\"SFJJYJJJJNL\":\"\",\"KSYJNL\":\"\",\"JYNSFJJ\":\"\",\"YJZL\":\"白酒,其他,啤酒,黄酒\",\"YJZLQT\":\"\",\"SG\":\"170\",\"TZ\":\"60.00\",\"TZZS\":\"20.00\",\"XL\":\"1\",\"FJJCSJ\":\"2020-08-07\",\"XJ\":\"11\",\"XN\":\"\",\"BASAJZYM\":\"3\",\"TMDASAJZYM\":\"1\",\"XNSD\":\"4\",\"XJG\":\"12\",\"XNS\":\"4\",\"SXQLGL\":\"3\",\"ZDGC\":\"5\",\"GYSZ\":\"\",\"DMDZDBDGC\":\"6\",\"GMDZDBDGC\":\"\",\"KFXT\":\"2\",\"THXHDB\":\"\",\"TXBGAS\":\"2\",\"XDT\":\"正常\",\"XDTYC\":\"1\",\"GSHZFH1\":\"否\",\"GSHZFH2\":\"否\",\"GSHZFH3\":\"否\",\"GSHZFH4\":\"否\",\"EXZL\":\"否\",\"GNZA\":\"否\",\"WCN\":\"否\",\"JZ\":\"否\",\"BTL\":\"否\",\"RSQ\":\"否\",\"KZYS\":\"是\",\"YDCS\":\"否\",\"SFYYYES\":\"按医嘱坚持服药\",\"SFYY\":\"是\",\"JDFY\":\"2\",\"DRUGS\":[{\"YWMC\":\"阿莫西林胶囊\",\"YWYF\":\"口服\",\"YWJL\":\"2\",\"YWSJ\":\"\",\"YWYCX\":\"\"},{\"YWMC\":\"阿莫西林胶囊2\",\"YWYF\":\"口服\",\"YWJL\":\"2\",\"YWSJ\":\"\",\"YWYCX\":\"\"},{\"YWMC\":\"\",\"YWYF\":\"\",\"YWJL\":\"\",\"YWSJ\":\"\",\"YWYCX\":\"\"},{\"YWMC\":\"\",\"YWYF\":\"\",\"YWJL\":\"\",\"YWSJ\":\"\",\"YWYCX\":\"\"},{\"YWMC\":\"\",\"YWYF\":\"\",\"YWJL\":\"\",\"YWSJ\":\"\",\"YWYCX\":\"\"},{\"YWMC\":\"\",\"YWYF\":\"\",\"YWJL\":\"\",\"YWSJ\":\"\",\"YWYCX\":\"\"}],\"JXXJGS\":\"有\",\"JXXJGSYES\":\"住院治疗\",\"JXXJGSFBRQ\":\"2020-08-07\",\"BWDXJT\":\"有\",\"BWDXJTYES\":\"\",\"BWDXJTFBRQ\":\"2020-08-07\",\"XSZYZL\":\"无\",\"XSFJ\":\"IV级\",\"XSZYZLFBRQ\":\"2020-08-07\",\"XYCJ\":\"有\",\"XYCJRGY\":\"介入治疗/支架\",\"XYCJRQ\":\"2020-08-07\",\"NZZ\":\"有\",\"NZZSFZY\":\"有\",\"NZZFBRQ\":\"2020-08-07\",\"NZZSFZYZDYJ\":\"有\",\"NZZFL\":\"脑出血\",\"NLJBS\":\"有\",\"NLJBSZDRQ\":\"2020-08-07\",\"NLJBSJBZD\":\"\",\"BLSJJLJYN\":\"无\",\"BLSJS\":[{\"BLSJMC\":\"\",\"BLSJFSSJ\":\"2020-08-07\",\"BLSJJSSJ\":\"2020-08-07\",\"BLSJYZCD\":\"轻度:有不适感，但不影响正常的日常活动\",\"BLSJSFJDFS\":\"是\",\"BLSJCL\":\"\",\"BLSJYWJL\":\"\",\"BLSJJYYWGX\":\"\",\"BLSJZG\":\"缓解无后遗症\"},{\"BLSJMC\":\"\",\"BLSJFSSJ\":\"2020-08-07\",\"BLSJJSSJ\":\"2020-08-07\",\"BLSJYZCD\":\"轻度:有不适感，但不影响正常的日常活动\",\"BLSJSFJDFS\":\"是\",\"BLSJCL\":\"\",\"BLSJYWJL\":\"否\",\"BLSJJYYWGX\":\"肯定有关\",\"BLSJZG\":\"\"},{\"BLSJMC\":\"\",\"BLSJFSSJ\":\"2020-08-07\",\"BLSJJSSJ\":\"2020-08-07\",\"BLSJYZCD\":\"\",\"BLSJSFJDFS\":\"\",\"BLSJCL\":\"\",\"BLSJYWJL\":\"\",\"BLSJJYYWGX\":\"\",\"BLSJZG\":\"\"}],\"manaUnitId\":\"320124001022\",\"createUser\":\"05100228\",\"createUnit\":\"320124001022\",\"createdate\":\"2020-08-07\",\"YSZDY\":\"120/80\",\"YSZDE\":\"135/90\",\"ZSZDY\":\"140/87\",\"ZSZDE\":\"150/99\"}";
        return JSON.parseObject(dataStr);
    }
}
