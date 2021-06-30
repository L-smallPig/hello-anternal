package com.pro.springboot.utils;

import com.pro.springboot.httputils.HttpclientUtil;

/**
 * @ClassName: ExtendThread
 * @Description: 工具类
 * @Author: 【liguangyue】
 * @Date: 2020-12-15
 **/
public class ExtendThread extends Thread {

	private int i;

	/**
	 * @Description: 压力测试
	 * @Author: liguangyue
	 * @Param: args
	 * @Return: void
	 * @Date: 2020-12-16
	 **/
	public static void main(String[] args) {
		for(int j = 0;j < 2000;j++) {

//			//调用Thread类的currentThread()方法获取当前线程
//			System.out.println(Thread.currentThread().getName() + " " + j);

//			if(j == 2) {
			//创建并启动第一个线程
			new ExtendThread().start();

			//创建并启动第二个线程
//				new ExtendThread().start();
//			}
		}
	}

	public void run() {
		String name = Thread.currentThread().getName();
		String id = name.substring(name.lastIndexOf("-")+1);
		Integer num = 397001+Integer.parseInt(id);
       String invoiceId = "0000"+ num;
		String token = "eyJhbGciOiJIUzUxMiJ9.eyJjcmVhdGVUaW1lIjoxNjA0Mzk4MzUwNDIxLCJ1c2VyTmFtZSI6ImFkbWluIn0.7MJy93wdiEwkaMAnguN0fHagwy9KdGVbm8ViKUB0SXE2cVDb2JSSIzhfng2FLditKzKocSRuMGFluTGmqVqHhg";
		String url="http://192.168.10.108:8080/api/invoke";
		try {
			String res = HttpclientUtil.sendHttpPost_JSON(url,"{\n" +
					"    \"zone_code\": \"320117\",\n" +
					"    \"invoicing_party_name\": \"南京市溧水区洪蓝镇卫生院\",\n" +
					"    \"invoicing_party_code\": \"320124006\",\n" +
					"    \"detail_item_list\": [\n" +
					"        {\n" +
					"            \"num\": 1,\n" +
					"            \"stdtype\": \"\",\n" +
					"            \"item_name\": \"床位费\",\n" +
					"            \"item_code\": \"32080201\",\n" +
					"            \"itemext\": {\n" +
					"                \"remark\": \"\",\n" +
					"                \"self_amt\": \"40.0\"\n" +
					"            },\n" +
					"            \"unit\": \"\",\n" +
					"            \"item_amount\": \"40.0\"\n" +
					"        },\n" +
					"        {\n" +
					"            \"num\": 2,\n" +
					"            \"stdtype\": \"\",\n" +
					"            \"item_name\": \"治疗费\",\n" +
					"            \"item_code\": \"32080205\",\n" +
					"            \"itemext\": {\n" +
					"                \"remark\": \"\",\n" +
					"                \"self_amt\": \"23.0\"\n" +
					"            },\n" +
					"            \"unit\": \"\",\n" +
					"            \"item_amount\": \"23.0\"\n" +
					"        },\n" +
					"         {\n" +
					"            \"num\": 2,\n" +
					"            \"stdtype\": \"\",\n" +
					"            \"item_name\": \"化验费\",\n" +
					"            \"item_code\": \"32080204\",\n" +
					"            \"itemext\": {\n" +
					"                \"remark\": \"\",\n" +
					"                \"self_amt\": \"242.0\"\n" +
					"            },\n" +
					"            \"unit\": \"\",\n" +
					"            \"item_amount\": \"242.0\"\n" +
					"        },\n" +
					"        {\n" +
					"            \"item_amount\": \"201.2\",\n" +
					"            \"num\": 3,\n" +
					"            \"item_code\": \"32080209\",\n" +
					"            \"stdtype\": \"\",\n" +
					"            \"item_name\": \"西药费\",\n" +
					"            \"itemext\": {\n" +
					"                \"self_amt\": \"201.2\",\n" +
					"                \"remark\": \"\"\n" +
					"            },\n" +
					"            \"unit\": \"\"\n" +
					"        },\n" +
					"        {\n" +
					"            \"stdtype\": \"\",\n" +
					"            \"num\": 1,\n" +
					"            \"item_name\": \"护理费\",\n" +
					"            \"item_code\": \"32080207\",\n" +
					"            \"itemext\": {\n" +
					"                \"remark\": \"\",\n" +
					"                \"self_amt\": \"22.0\"\n" +
					"            },\n" +
					"            \"unit\": \"\",\n" +
					"            \"item_amount\": \"22.0\"\n" +
					"        },\n" +
					"        {\n" +
					"            \"num\": 1,\n" +
					"            \"stdtype\": \"\",\n" +
					"            \"item_name\": \"诊察费\",\n" +
					"            \"item_code\": \"32080202\",\n" +
					"            \"itemext\": {\n" +
					"                \"remark\": \"\",\n" +
					"                \"self_amt\": \"7.0\"\n" +
					"            },\n" +
					"            \"unit\": \"\",\n" +
					"            \"item_amount\": \"7.0\"\n" +
					"        }\n" +
					"    ],\n" +
					"    \"bizcode\": \"3310602\",\n" +
					"    \"version\": \"1.1\",\n" +
					"    \"total_amount\": 535.2,\n" +
					"    \"his_info\": {\n" +
					"         \"med_item_list\": [\n" +
					"             {\n" +
					"                \"std\": 40.0,\n" +
					"                \"num\": 1,\n" +
					"                \"chrg_type_name\": \"床位费\",\n" +
					"                \"remark\": \"芮小英\",\n" +
					"                \"item_name\": \"三人间床位费/日\",\n" +
					"                \"item_code\": \"\",\n" +
					"                \"self_amt\": 40.0,\n" +
					"                \"amt\": 40.0,\n" +
					"                \"chrg_type_code\": \"32080201\",\n" +
					"                \"unit\":\"天\"\n" +
					"            },\n" +
					"            {\n" +
					"                \"std\": 8.0,\n" +
					"                \"num\": 1,\n" +
					"                \"chrg_type_name\": \"治疗费\",\n" +
					"                \"remark\": \"芮小英\",\n" +
					"                \"item_name\": \"穴位贴敷治疗/穴位\",\n" +
					"                \"item_code\": \"\",\n" +
					"                \"self_amt\": 8.0,\n" +
					"                \"amt\": 8.0,\n" +
					"                \"chrg_type_code\": \"32080205\",\n" +
					"                \"unit\":\"次\"\n" +
					"            },\n" +
					"            {\n" +
					"                \"std\": 15.0,\n" +
					"                \"num\": 1,\n" +
					"                \"chrg_type_name\": \"治疗费\",\n" +
					"                \"remark\": \"芮小英\",\n" +
					"                \"item_name\": \"耳针/单耳\",\n" +
					"                \"item_code\": \"\",\n" +
					"                \"self_amt\": 15.0,\n" +
					"                \"amt\": 15.0,\n" +
					"                \"chrg_type_code\": \"32080205\",\n" +
					"                \"unit\":\"次\"\n" +
					"            },\n" +
					"             {\n" +
					"                \"chrg_type_name\": \"化验费\",\n" +
					"                \"self_amt\": 230.0,\n" +
					"                \"amt\": 230.0,\n" +
					"                \"std\": 230.0,\n" +
					"                \"remark\": \"芮小英\",\n" +
					"                \"item_name\": \"B型钠尿肽前体(PRO-BNP)测定(发光法)\",\n" +
					"                \"item_code\": \"\",\n" +
					"                \"num\": 1,\n" +
					"                \"chrg_type_code\": \"32080204\",\n" +
					"                \"unit\":\"项\"\n" +
					"            },\n" +
					"             {\n" +
					"                \"chrg_type_name\": \"化验费\",\n" +
					"                \"self_amt\": 12.0,\n" +
					"                \"amt\": 12.0,\n" +
					"                \"std\": 12.0,\n" +
					"                \"remark\": \"芮小英\",\n" +
					"                \"item_name\": \"粪便隐血试验(OB)(金标法)\",\n" +
					"                \"item_code\": \"\",\n" +
					"                \"num\": 1,\n" +
					"                \"chrg_type_code\": \"32080204\",\n" +
					"                \"unit\":\"项\"\n" +
					"            },\n" +
					"            {\n" +
					"                \"chrg_type_name\": \"西药费\",\n" +
					"                \"self_amt\": 19.2,\n" +
					"                \"amt\": 19.2,\n" +
					"                \"std\": 19.2,\n" +
					"                \"remark\": \"芮小英\",\n" +
					"                \"item_name\": \"琥珀酸亚铁片(薄膜衣)/0.1g*20/盒\",\n" +
					"                \"item_code\": \"\",\n" +
					"                \"num\": 1,\n" +
					"                \"chrg_type_code\": \"32080209\",\n" +
					"                \"unit\":\"盒\"\n" +
					"            },\n" +
					"             {\n" +
					"                \"chrg_type_name\": \"西药费\",\n" +
					"                \"self_amt\": 176.2,\n" +
					"                \"amt\": 176.2,\n" +
					"                \"std\": 88.1,\n" +
					"                \"remark\": \"芮小英\",\n" +
					"                \"item_name\": \"烟酸注射液/5ml：50mg/支\",\n" +
					"                \"item_code\": \"\",\n" +
					"                \"num\": 2,\n" +
					"                \"chrg_type_code\": \"32080209\",\n" +
					"                \"unit\":\"支\"\n" +
					"            },\n" +
					"            {\n" +
					"                \"chrg_type_name\": \"西药费\",\n" +
					"                \"self_amt\": 5.8,\n" +
					"                \"amt\": 5.8,\n" +
					"                \"std\": 2.9,\n" +
					"                \"remark\": \"芮小英\",\n" +
					"                \"item_name\": \"氯化钠注射液/250ml:2.25g(0.9%)/袋\",\n" +
					"                \"item_code\": \"\",\n" +
					"                \"num\": 2,\n" +
					"                \"chrg_type_code\": \"32080209\",\n" +
					"                \"unit\":\"袋\"\n" +
					"            },\n" +
					"            {\n" +
					"                \"item_name\": \"二级护理/日\",\n" +
					"                \"amt\": 22.0,\n" +
					"                \"num\": 1,\n" +
					"                \"chrg_type_code\": \"32080207\",\n" +
					"                \"chrg_type_name\": \"护理费\",\n" +
					"                \"remark\": \"芮小英\",\n" +
					"                \"std\": 22.0,\n" +
					"                \"item_code\": \"\",\n" +
					"                \"self_amt\": 22.0,\n" +
					"                \"unit\":\"天\"\n" +
					"            },\n" +
					"            {\n" +
					"                \"item_name\": \"住院诊查费/日\",\n" +
					"                \"amt\": 7.0,\n" +
					"                \"num\": 1,\n" +
					"                \"chrg_type_code\": \"32080202\",\n" +
					"                \"chrg_type_name\": \"诊察费\",\n" +
					"                \"remark\": \"芮小英\",\n" +
					"                \"std\": 7.0,\n" +
					"                \"item_code\": \"\",\n" +
					"                \"self_amt\": 7.0,\n" +
					"                \"unit\":\"天\"\n" +
					"            }          \n" +
					"        ],\n" +
					"        \"bizinfo\": {\n" +
					"            \"patient_id\": \"797434\",\n" +
					"            \"sex\": \"女\",\n" +
					"            \"med_bedinfo\":{\n" +
					"                \"hospital_no\":\"50802\",\n" +
					"                \"in_category\":\"住院综合科\"\n" +
					"            },\n" +
					"            \"medcare_type\": \"南京金保\",\n" +
					"            \"biztype\": \"01\",\n" +
					"            \"age\": \"56\"\n" +
					"        },\n" +
					"        \"biztime\": \"2020-11-09 08:11:13\",\n" +
					"        \"trade_info\": {\n" +
					"\n" +
					"            \"pay_channel_list\": [\n" +
					"                {\n" +
					"                    \"channel_code\": \"11\",\n" +
					"                    \"channel_amt\": 32.7\n" +
					"                }, {\n" +
					"                    \"channel_code\": \"02\",\n" +
					"                    \"channel_amt\": 1.0\n" +
					"                }\n" +
					"            ],\n" +
					"            \"account_pay\": 151.8,\n" +
					"            \"own_pay\": 80.8,\n" +
					"            \"fund_pay\": 302.6,\n" +
					"            \"acct_Balance\": 0.0,           \n" +
					"            \"cash_pay\": 0.0,\n" +
					"            \"cash_refund\": 0.0,\n" +
					"            \"otherfund_pay\":0.0\n" +
					"\n" +
					"\n" +
					"        },\n" +
					"        \"card_no\": \"\",\n" +
					"        \"reimburse_info\": {\n" +
					"            \"ill_assist\": 0.0,\n" +
					"            \"civil_assist\": 0.0,\n" +
					"            \"med_insur\": 0.0,\n" +
					"            \"ill_insur\": 0.0,\n" +
					"            \"self_pay\": 151.80,\n" +
					"            \"self_cost\": 80.8\n" +
					"        },\n" +
					"        \"card_type\": \"3101\",\n" +
					"        \"payee\": \"芮小英\"\n" +
					"    },\n" +
					"    \"co_code\": \"320117150001\",\n" +
					"\n" +
					"    \"checker\": \"栗粟\",\n" +
					"    \"rec_name\":\"栗粟\",\n" +
					"    \"invoice_number\": \"0000321600\",\n" +
					"    \"invoicing_seal_id\": \"32011715000112\",\n" +
					"\n" +
					"    \"random\": \"206287\",\n" +
					"    \"method\": \"invoicehisissue\",\n" +
					"    \"payer_party_code\": \"320124193801152421\",\n" +
					"    \"invoice_code\": \"32060220\",\n" +
					"    \"recipient_addr\": {\n" +
					"        \"email\": \"\",\n" +
					"        \"telephone\": \"15952073396\"\n" +
					"    },\n" +
					"    \"payer_party_type\": \"1\",\n" +
					"    \"payer_party_name\": \"芮小英\",\n" +
					"    \"handling_person\": \"栗粟\",\n" +
					"    \"timestamp\": null,\n" +
					"    \"app_id\": \"320117150001\"\n" +
					"}", token);
			System.out.println(res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
	



