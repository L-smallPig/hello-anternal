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
            "    \"name\": \"???????????????\",\n" +
            "    \"content\": {\n" +
            "      \"title\": \"???????????????\",\n" +
            "      \"data\": [\n" +
            "        {\n" +
            "          \"sort\": 1,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"????????????\",\n" +
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
            "            \"name\": \"????????????\",\n" +
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
            "            \"name\": \"??????\",\n" +
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
            "            \"name\": \"????????????\",\n" +
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
            "            \"name\": \"??????\",\n" +
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
            "            \"name\": \"????????????\",\n" +
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
            "            \"name\": \"??????\",\n" +
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
            "            \"name\": \"????????????\",\n" +
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
            "            \"name\": \"??????\",\n" +
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
            "            \"name\": \"???????????????\",\n" +
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
            "            \"name\": \"?????????????????????\",\n" +
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
            "    \"name\": \"????????????????????????\",\n" +
            "    \"content\": {\n" +
            "      \"title\": \"????????????????????????\",\n" +
            "      \"data\": [\n" +
            "        {\n" +
            "          \"sort\": 1,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"???\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"??????\",\n" +
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
            "                \"name\": \"?????????\",\n" +
            "                \"code\": \"GXY\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.GXY}}\",\n" +
            "                \"code\": \"GXY\"\n" +
            "              }\n" +
            "            {{if( it.GXY === '???'){ }}\n" +
            "              ,\"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"?????????????????????\",\n" +
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
            "                    \"name\": \"?????????????????????\",\n" +
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
            "                    \"name\": \"??????????????????\",\n" +
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
            "                \"name\": \"?????????\",\n" +
            "                \"code\": \"TNB\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.TNB}}\",\n" +
            "                \"code\": \"TNB\"\n" +
            "              }\n" +
            "            {{if(it.TNB=='???'){ }}\n" +
            "              ,\"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"????????????\",\n" +
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
            "                    \"name\": \"?????????????????????????????????\",\n" +
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
            "                \"name\": \"????????????\",\n" +
            "                \"code\": \"GZXZ\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.GZXZ}}\",\n" +
            "                \"code\": \"GZXZ\"\n" +
            "              }\n" +
            "            {{if(it.GZXZ=='???') { }}\n" +
            "              ,\"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"????????????\",\n" +
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
            "                    \"name\": \"????????????\",\n" +
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
            "                \"name\": \"?????????????????????\",\n" +
            "                \"code\": \"JWYWGXB\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.JWYWGXB}}\",\n" +
            "                \"code\": \"JWYWGXB\"\n" +
            "              }\n" +
            "            {{if(it.JWYWGXB=='???') { }}\n" +
            "              ,\"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"????????????\",\n" +
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
            "                \"name\": \"?????????????????????\",\n" +
            "                \"code\": \"JWYWNZZ\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.JWYWNZZ}}\",\n" +
            "                \"code\": \"JWYWNZZ\"\n" +
            "              }\n" +
            "             {{if(it.JWYWNZZ=='???'){ }}\n" +
            "              ,\"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"????????????\",\n" +
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
            "                \"name\": \"????????????????????????????????????????????????????????????????????????\",\n" +
            "                \"code\": \"YWQTJB\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.YWQTJB}}\",\n" +
            "                \"code\": \"YWQTJB\"\n" +
            "              }\n" +
            "            {{if(it.YWQTJB=='???'){ }}\n" +
            "              ,\"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"????????????\",\n" +
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
            "          \"prefix\": \"???\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"???????????????????????????????????????\",\n" +
            "            \"code\": \"?????????\"\n" +
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
            "                \"name\": \"??????????????????\",\n" +
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
            "                \"name\": \"??????????????????\",\n" +
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
            "                \"name\": \"??????????????????\",\n" +
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
            "                \"name\": \"??????????????????\",\n" +
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
            "          \"prefix\": \"???\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"????????????\",\n" +
            "            \"code\": \"?????????\"\n" +
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
            "                \"name\": \"??????\",\n" +
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
            "                \"name\": \"???????????????????????????\",\n" +
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
            "                \"name\": \"????????????\",\n" +
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
            "                    \"name\": \"??????????????????\",\n" +
            "                    \"code\": \"XYZKJYKSNL\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.XYZKJYKSNL}} ???\",\n" +
            "                    \"code\": \"XYZKJYKSNL\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 2,\n" +
            "                  \"level\": 2,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"????????????\",\n" +
            "                    \"code\": \"XYZKJYMTJZ\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.XYZKJYMTJZ}} ???/???\",\n" +
            "                    \"code\": \"XYZKJYMTJZ\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 3,\n" +
            "                  \"level\": 2,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"????????????\",\n" +
            "                    \"code\": \"XYZKJYNL\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.XYZKJYNL}} ???\",\n" +
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
            "                \"name\": \"????????????\",\n" +
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
            "                    \"name\": \"????????????\",\n" +
            "                    \"code\": \"YJQKORMTJL\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.YJQKORMTJL}} ???/???\",\n" +
            "                    \"code\": \"YJQKORMTJL\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 2,\n" +
            "                  \"level\": 2,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"????????????\",\n" +
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
            "                    \"name\": \"????????????\",\n" +
            "                    \"code\": \"SFJJYJJJJNL\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.SFJJYJJJJNL}} ???\",\n" +
            "                    \"code\": \"SFJJYJJJJNL\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 4,\n" +
            "                  \"level\": 2,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"??????????????????\",\n" +
            "                    \"code\": \"KSYJNL\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=it.KSYJNL}} ???\",\n" +
            "                    \"code\": \"KSYJNL\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 5,\n" +
            "                  \"level\": 2,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"???????????????????????????\",\n" +
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
            "                    \"name\": \"????????????\",\n" +
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
            "    \"name\": \"????????????\",\n" +
            "    \"content\": {\n" +
            "      \"title\": \"????????????\",\n" +
            "      \"data\": [\n" +
            "        {\n" +
            "          \"sort\": 1,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"???\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"????????????\",\n" +
            "            \"code\": \"?????????\"\n" +
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
            "                \"name\": \"??????\",\n" +
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
            "                \"name\": \"??????\",\n" +
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
            "                \"name\": \"???????????????BMI???\",\n" +
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
            "          \"prefix\": \"???\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"????????????\",\n" +
            "            \"code\": \"?????????\"\n" +
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
            "                \"name\": \"???????????????\",\n" +
            "                \"code\": \"?????????\"\n" +
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
            "                    \"name\": \"???????????????\",\n" +
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
            "                    \"name\": \"???????????????\",\n" +
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
            "                \"name\": \"???????????????\",\n" +
            "                \"code\": \"?????????\"\n" +
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
            "                    \"name\": \"???????????????\",\n" +
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
            "                    \"name\": \"???????????????\",\n" +
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
            "                \"name\": \"??????\",\n" +
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
            "    \"name\": \"????????????\",\n" +
            "    \"content\": {\n" +
            "      \"title\": \"????????????\",\n" +
            "      \"data\": [\n" +
            "        {\n" +
            "          \"sort\": 1,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"???\",\n" +
            "          \"type\": \"click\",\n" +
            "          \"icon\": \"http://www.baidu.com\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"???????????????\",\n" +
            "            \"code\": \"?????????\"\n" +
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
            "                \"name\": \"????????????\",\n" +
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
            "                \"name\": \"??????(K)\",\n" +
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
            "                \"name\": \"??????(Na)\",\n" +
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
            "                \"name\": \"????????????????????????(ALT)\",\n" +
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
            "                \"name\": \"??????????????????????????????(AST)\",\n" +
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
            "                \"name\": \"????????????(BUN)\",\n" +
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
            "                \"name\": \"?????????(CREA)\",\n" +
            "                \"code\": \"XJG\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.XJG}} ??mol/L\",\n" +
            "                \"code\": \"XJG\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 8,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"?????????(UA)\",\n" +
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
            "                \"name\": \"?????????????????????eGFR???\",\n" +
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
            "                \"name\": \"????????????(TC)\",\n" +
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
            "                \"name\": \"????????????(TG)\",\n" +
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
            "                \"name\": \"???????????????????????????(LDL-C)\",\n" +
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
            "                \"name\": \"???????????????????????????(HLD-C)\",\n" +
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
            "                \"name\": \"????????????(FBG)\",\n" +
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
            "                \"name\": \"??????????????????(HbA1c)\",\n" +
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
            "                \"name\": \"??????????????????(Hcy)\",\n" +
            "                \"code\": \"TXBGAS\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.TXBGAS}} ??mol/L\",\n" +
            "                \"code\": \"TXBGAS\"\n" +
            "              }\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        {\n" +
            "          \"sort\": 2,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"???\",\n" +
            "          \"type\": \"click\",\n" +
            "          \"icon\": \"http://www.baidu.com\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"????????????ECG)\",\n" +
            "            \"code\": \"?????????\"\n" +
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
            "                \"name\": \"?????????????????????\",\n" +
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
            "                \"name\": \"????????????\",\n" +
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
            "    \"name\": \"????????????????????????\",\n" +
            "    \"content\": {\n" +
            "      \"title\": \"????????????????????????\",\n" +
            "      \"data\": [\n" +
            "        {\n" +
            "          \"sort\": 1,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"???\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"????????????????????????\",\n" +
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
            "          \"prefix\": \"???\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"?????????????????????\",\n" +
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
            "          \"prefix\": \"???\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"????????????\",\n" +
            "            \"code\": \"SFYY+SFYYYES\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"{{=it.SFYY}},{{=it.SFYYYES}}\",\n" +
            "            \"code\": \"SFYY+SFYYYES\"\n" +
            "          }\n" +
            "        {{if(it.SFYY=='???') { }}\n" +
            "          ,\"child\": [\n" +
            "            {\n" +
            "              \"sort\": 1,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"????????????\",\n" +
            "                \"code\": \"JDFY\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.JDFY}} ??????\",\n" +
            "                \"code\": \"JDFY\"\n" +
            "              }\n" +
            "            },\n" +
            "            {\n" +
            "              \"sort\": 1,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \"\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"??????????????????\",\n" +
            "                \"code\": \"?????????\"\n" +
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
            "                      \"name\": \"????????????\",\n" +
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
            "                          \"name\": \"????????????\",\n" +
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
            "                          \"name\": \"????????????\",\n" +
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
            "                          \"name\": \"??????\",\n" +
            "                          \"code\": \"YWJL\"\n" +
            "                        },\n" +
            "                        \"value\": {\n" +
            "                          \"name\": \"{{=DRUG.YWJL}} mg/???\",\n" +
            "                          \"code\": \"YWJL\"\n" +
            "                        }\n" +
            "                      },\n" +
            "                      {\n" +
            "                        \"sort\": 4,\n" +
            "                        \"level\": 4,\n" +
            "                        \"prefix\": \"\",\n" +
            "                        \"type\": \"text\",\n" +
            "                        \"key\": {\n" +
            "                          \"name\": \"????????????\",\n" +
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
            "                          \"name\": \"???????????????\",\n" +
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
            "    \"name\": \"????????????????????????\",\n" +
            "    \"content\": {\n" +
            "      \"title\": \"????????????????????????\",\n" +
            "      \"data\": [\n" +
            "        {\n" +
            "          \"sort\": 1,\n" +
            "          \"level\": 1,\n" +
            "          \"prefix\": \"???\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"?????????????????????1??????\",\n" +
            "            \"code\": \"?????????\"\n" +
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
            "                \"name\": \"??????????????????\",\n" +
            "                \"code\": \"JXXJGS+JXXJGSYES\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.JXXJGS}}  {{=it.JXXJGSYES}}\",\n" +
            "                \"code\": \"JXXJGS+JXXJGSYES\"\n" +
            "              }\n" +
            "            {{if(it.JXXJGS=='???') { }}\n" +
            "              ,\"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"????????????\",\n" +
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
            "                \"name\": \"??????????????????\",\n" +
            "                \"code\": \"BWDXJT+BWDXJTYES\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.BWDXJT}}  {{=it.BWDXJTYES}}\",\n" +
            "                \"code\": \"BWDXJT+BWDXJTYES\"\n" +
            "              }\n" +
            "            {{if(it.BWDXJT=='???') { }}\n" +
            "              ,\"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"????????????\",\n" +
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
            "                \"name\": \"??????????????????\",\n" +
            "                \"code\": \"XSZYZL\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.XSZYZL}}\",\n" +
            "                \"code\": \"XSZYZL\"\n" +
            "              }\n" +
            "             {{if(it.XSZYZL=='???') { }}\n" +
            "              ,\"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"????????????\",\n" +
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
            "                \"name\": \"????????????\",\n" +
            "                \"code\": \"XYCJ+XYCJRGY\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.XYCJ}} {{=it.XYCJRGY}}\",\n" +
            "                \"code\": \"XYCJ+XYCJRGY\"\n" +
            "              }\n" +
            "            {{if(it.XYCJ=='???') { }}\n" +
            "              ,\"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"????????????\",\n" +
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
            "          \"prefix\": \"???\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"?????????????????????1??????\",\n" +
            "            \"code\": \"?????????\"\n" +
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
            "                \"name\": \"?????????\",\n" +
            "                \"code\": \"NZZ\"\n" +
            "              },\n" +
            "              \"value\": {\n" +
            "                \"name\": \"{{=it.NZZ}}\",\n" +
            "                \"code\": \"NZZ\"\n" +
            "              }\n" +
            "            {{if(it.NZZ=='???'){ }}\n" +
            "              ,\"child\": [\n" +
            "                {\n" +
            "                  \"sort\": 1,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"????????????\",\n" +
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
            "                    \"name\": \"????????????\",\n" +
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
            "                    \"name\": \"?????????????????????CT????????????\",\n" +
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
            "                    \"name\": \"???????????????\",\n" +
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
            "          \"prefix\": \"???\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"?????????????????????1??????\",\n" +
            "            \"code\": \"NLJBS\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"{{=it.NLJBS}}\",\n" +
            "            \"code\": \"NLJBS\"\n" +
            "          }\n" +
            "        {{if(it.NLJBS=='???') { }}\n" +
            "          ,\"child\": [\n" +
            "            {\n" +
            "              \"sort\": 1,\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"????????????\",\n" +
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
            "                    \"name\": \"????????????\",\n" +
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
            "          \"prefix\": \"???\",\n" +
            "          \"type\": \"text\",\n" +
            "          \"key\": {\n" +
            "            \"name\": \"????????????????????????1??????\",\n" +
            "            \"code\": \"BLSJJLJYN\"\n" +
            "          },\n" +
            "          \"value\": {\n" +
            "            \"name\": \"{{=it.BLSJJLJYN}}\",\n" +
            "            \"code\": \"BLSJJLJYN\"\n" +
            "          }\n" +
            "        {{if(it.BLSJJLJYN=='???') { }}\n" +
            "          ,\"child\": [\n" +
            "          {{~it.BLSJS:BLSJ:index}}\n" +
            "          {{if(index!=0) { }},{{ } }}\n" +
            "            {\n" +
            "              \"sort\": {{=index+1}},\n" +
            "              \"level\": 2,\n" +
            "              \"prefix\": \")\",\n" +
            "              \"type\": \"text\",\n" +
            "              \"key\": {\n" +
            "                \"name\": \"?????????\",\n" +
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
            "                    \"name\": \"????????????\",\n" +
            "                    \"code\": \"BLSJFSSJ+BLSJJSSJ\"\n" +
            "                  },\n" +
            "                  \"value\": {\n" +
            "                    \"name\": \"{{=BLSJ.BLSJFSSJ}}???{{=BLSJ.BLSJJSSJ}}\",\n" +
            "                    \"code\": \"BLSJFSSJ+BLSJJSSJ\"\n" +
            "                  }\n" +
            "                },\n" +
            "                {\n" +
            "                  \"sort\": 2,\n" +
            "                  \"level\": 3,\n" +
            "                  \"prefix\": \"\",\n" +
            "                  \"type\": \"text\",\n" +
            "                  \"key\": {\n" +
            "                    \"name\": \"????????????\",\n" +
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
            "                    \"name\": \"??????????????????\",\n" +
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
            "                    \"name\": \"??????????????????????????????\",\n" +
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
            "                    \"name\": \"?????????????????????\",\n" +
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
            "                    \"name\": \"??????\",\n" +
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
            "                    \"name\": \"??????\",\n" +
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
//        System.out.println("??????????????????:" + c);
//        JSONObject result = JSON.parseObject(c);
//        System.out.println(JSON.toJSONString(result, false));
        System.out.println(c);
    }

    private static JSONObject getData() {
        String dataStr = "{\"idCard\":\"142636198802065315\",\"name\":\"??????\",\"sexcode\":\"???\",\"birthday\":\"1988-02-06\",\"age\":\"32\",\"education\":\"???????????????????????????\",\"nation\":\"??????\",\"address\":\"??????????????????????????????101???\",\"phone\":\"18511548631\",\"contactPeople\":\"??????\",\"iecPhone\":\"18511548631\",\"phrId\":\"\",\"empiId\":\"4e9db3957e764825b0804be429c44979\",\"fillingDate\":\"2020-08-07\",\"GXY\":\"???\",\"GXYZDSJ\":\"2020-08-07\",\"SFFYJYY\":\"\",\"KSYYSJ\":\"2020-08-07\",\"TNB\":\"???\",\"TNBZDSJ\":\"2020-08-07\",\"SFFYJTY\":\"\",\"GZXZ\":\"??????\",\"GZXZZDSJ\":\"2020-08-07\",\"GZXZSFYY\":\"\",\"JWYWGXB\":\"???\",\"GXBZDSJ\":\"2020-08-07\",\"JWYWNZZ\":\"???\",\"NZZZDSJ\":\"2020-08-07\",\"YWQTJB\":\"??????\",\"YWQTJBJT\":\"\",\"GXYJZS\":\"???\",\"GXBJZS\":\"???\",\"TNBJZS\":\"???\",\"NZZJZS\":\"???\",\"DH\":\"???\",\"SFYSMHXZT\":\"???\",\"XYZK\":\"??????\",\"XYZKJYKSNL\":\"\",\"XYZKJYMTJZ\":\"\",\"XYZKJYNL\":\"\",\"YJQK\":\"??????\",\"YJQKORMTJL\":\"\",\"SFJJ\":\"?????????\",\"SFJJYJJJJNL\":\"\",\"KSYJNL\":\"\",\"JYNSFJJ\":\"\",\"YJZL\":\"??????,??????,??????,??????\",\"YJZLQT\":\"\",\"SG\":\"170\",\"TZ\":\"60.00\",\"TZZS\":\"20.00\",\"XL\":\"1\",\"FJJCSJ\":\"2020-08-07\",\"XJ\":\"11\",\"XN\":\"\",\"BASAJZYM\":\"3\",\"TMDASAJZYM\":\"1\",\"XNSD\":\"4\",\"XJG\":\"12\",\"XNS\":\"4\",\"SXQLGL\":\"3\",\"ZDGC\":\"5\",\"GYSZ\":\"\",\"DMDZDBDGC\":\"6\",\"GMDZDBDGC\":\"\",\"KFXT\":\"2\",\"THXHDB\":\"\",\"TXBGAS\":\"2\",\"XDT\":\"??????\",\"XDTYC\":\"1\",\"GSHZFH1\":\"???\",\"GSHZFH2\":\"???\",\"GSHZFH3\":\"???\",\"GSHZFH4\":\"???\",\"EXZL\":\"???\",\"GNZA\":\"???\",\"WCN\":\"???\",\"JZ\":\"???\",\"BTL\":\"???\",\"RSQ\":\"???\",\"KZYS\":\"???\",\"YDCS\":\"???\",\"SFYYYES\":\"?????????????????????\",\"SFYY\":\"???\",\"JDFY\":\"2\",\"DRUGS\":[{\"YWMC\":\"??????????????????\",\"YWYF\":\"??????\",\"YWJL\":\"2\",\"YWSJ\":\"\",\"YWYCX\":\"\"},{\"YWMC\":\"??????????????????2\",\"YWYF\":\"??????\",\"YWJL\":\"2\",\"YWSJ\":\"\",\"YWYCX\":\"\"},{\"YWMC\":\"\",\"YWYF\":\"\",\"YWJL\":\"\",\"YWSJ\":\"\",\"YWYCX\":\"\"},{\"YWMC\":\"\",\"YWYF\":\"\",\"YWJL\":\"\",\"YWSJ\":\"\",\"YWYCX\":\"\"},{\"YWMC\":\"\",\"YWYF\":\"\",\"YWJL\":\"\",\"YWSJ\":\"\",\"YWYCX\":\"\"},{\"YWMC\":\"\",\"YWYF\":\"\",\"YWJL\":\"\",\"YWSJ\":\"\",\"YWYCX\":\"\"}],\"JXXJGS\":\"???\",\"JXXJGSYES\":\"????????????\",\"JXXJGSFBRQ\":\"2020-08-07\",\"BWDXJT\":\"???\",\"BWDXJTYES\":\"\",\"BWDXJTFBRQ\":\"2020-08-07\",\"XSZYZL\":\"???\",\"XSFJ\":\"IV???\",\"XSZYZLFBRQ\":\"2020-08-07\",\"XYCJ\":\"???\",\"XYCJRGY\":\"????????????/??????\",\"XYCJRQ\":\"2020-08-07\",\"NZZ\":\"???\",\"NZZSFZY\":\"???\",\"NZZFBRQ\":\"2020-08-07\",\"NZZSFZYZDYJ\":\"???\",\"NZZFL\":\"?????????\",\"NLJBS\":\"???\",\"NLJBSZDRQ\":\"2020-08-07\",\"NLJBSJBZD\":\"\",\"BLSJJLJYN\":\"???\",\"BLSJS\":[{\"BLSJMC\":\"\",\"BLSJFSSJ\":\"2020-08-07\",\"BLSJJSSJ\":\"2020-08-07\",\"BLSJYZCD\":\"??????:????????????????????????????????????????????????\",\"BLSJSFJDFS\":\"???\",\"BLSJCL\":\"\",\"BLSJYWJL\":\"\",\"BLSJJYYWGX\":\"\",\"BLSJZG\":\"??????????????????\"},{\"BLSJMC\":\"\",\"BLSJFSSJ\":\"2020-08-07\",\"BLSJJSSJ\":\"2020-08-07\",\"BLSJYZCD\":\"??????:????????????????????????????????????????????????\",\"BLSJSFJDFS\":\"???\",\"BLSJCL\":\"\",\"BLSJYWJL\":\"???\",\"BLSJJYYWGX\":\"????????????\",\"BLSJZG\":\"\"},{\"BLSJMC\":\"\",\"BLSJFSSJ\":\"2020-08-07\",\"BLSJJSSJ\":\"2020-08-07\",\"BLSJYZCD\":\"\",\"BLSJSFJDFS\":\"\",\"BLSJCL\":\"\",\"BLSJYWJL\":\"\",\"BLSJJYYWGX\":\"\",\"BLSJZG\":\"\"}],\"manaUnitId\":\"320124001022\",\"createUser\":\"05100228\",\"createUnit\":\"320124001022\",\"createdate\":\"2020-08-07\",\"YSZDY\":\"120/80\",\"YSZDE\":\"135/90\",\"ZSZDY\":\"140/87\",\"ZSZDE\":\"150/99\"}";
        return JSON.parseObject(dataStr);
    }
}
