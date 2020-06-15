package com.incomehigher;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.beust.jcommander.internal.Lists;

public class BtcTotal {

	private  static final String URL="https://btc.com/";
	private static final  String[] BTC_ADDRESS= {
			"3KZ526NxCVXbKwwP66RgM3pte6zW4gY1tD" ,
			"37XuVSEpWW4trkfmvWzegTHQt7BdktSKUs" ,
			"37do5d3pKeCuozjNCApGT153GJ8oNmKYbB" ,
			"1FeexV6bAHb8ybZjqQMjJrcCrHGW9sb6uF" ,
			"3NnGcxybgm3drht65hRucr23Ya4ZmQqz4w" ,
			"3D8qAoMkZ8F1b42btt2Mn5TyN7sWfa434A" ,
			"1HQ3Go3ggs8pFnXuHVHRytPCq5fGG8Hbhx" ,
			"385cR5DM96n1HvBDMzLHPYcw89fZAXULJP" ,
			"1P5ZEDWTKTFGxQjZphgWPQUpe554WKDfHQ" ,
			"1LdRcdxfbSnmCYYNdeYpUnztiYzVfBEQeC" ,
			"386eAUqL3ZNZPmHeABXLo658DTQuJeLzUR" ,
			"1AC4fMwgY8j9onSbXEWeH6Zan8QGMSdmtA" ,
			"38UmuUqPCrFmQo4khkomQwZ4VbY2nZMJ67" ,
			"3Kzh9qAqVWQhEsfQz7zEQL1EuSx5tyNLNS" ,
			"1LruNZjwamWJXThX2Y8C2d47QqhAkkc5os" ,
			"1BX5MXZ95rMiQJBH9yKpcmbAt9VcfyAfHE" ,
			"17hf5H8D6Yc4B7zHEg3orAtKn7Jhme7Adx" ,
			"3LCGsSmfr24demGvriN4e3ft8wEcDuHFqh" ,
			"13JQwoSLLR3ffXwswe2HCTK9oq4i8MWK3q" ,
			"12ib7dApVFvg82TXKycWBNpN8kFyiAN1dr" ,
			"34xp4vRoCGJym3xR7yCVPFHoCNxv4Twseo" ,
			"12tkqA9xSoowkzoERHMWNKsTey55YEBqkv" ,
			"3H5JTt42K7RmZtromfTSefcMEFMMe18pMD" ,
			"3Pja5FPK1wFB9LkWWJai8XYL1qjbqqT9Ye" ,
			"3HroDXv8hmzKRtaSfBffRgedKpru8fgy6M" ,
			"1NH8vuaJaMXbtj4Qx6iFaQY8btdVcAn9iz" ,
			"1ANjYHibCQ6FzagLfeXubC8SQYDfUS5wAJ" ,
			"1AnwDVbwsLBVwRfqN2x9Eo4YEJSPXo2cwG" ,
			"1932eKraQ3Ad9MeNBHb14WFQbNrLaKeEpT" ,
			"14eQD1QQb8QFVG8YFwGz7skyzsvBLWLwJS" ,
			"3HHQzEDe6X5JCR2gKZHE1PNm9tykAVJWjK" ,
			"1aXzEKiDJKzkPxTZy9zGc3y1nCDwDPub2" ,
			"17rm2dvb439dZqyMe2d4D6AQJSgg6yeNRn" ,
			"1Fp9KLM6cs35y8QvyqAiL714WMFSLBJDLC" ,
			"12BZD75sbMmdj5dy1d5cS2Lo4YWs1FDbDn" ,
			"12nxRsisUcJqCDeUpTYH2a7F5jcad3YhFG" ,
			"1PeizMg76Cf96nUQrYg8xuoZWLQozU5zGW" ,
			"16GTzLcEsAm4tHhwtZV1F6gxYDMmbdSMrv" ,
			"3AbSEcJTvnSGsN2Ee99JLymRoLUbSFbmJx" ,
			"16FSBGvQfy4K8dYvPPWWpmzgKM6CvrCoVy" ,
			"3BMEXqGpG4FxBA1KWhRFufXfSTRgzfDBhJ" ,
			"1GR9qNz7zgtaW5HwwVpEJWMnGWhsbsieCG" ,
			"3N9an8wv4SYi3FVXs3xR5k2AqXeNZiw2mf" ,
			"38Md7BghVmV7XUUT1Vt9CvVcc5ssMD6ojt" ,
			"1KUr81aewyTFUfnq4ZrpePZqXixd59ToNn" ,
			"16XvGbSfhr4qhtfUBJ6XRZP44q4XpoqN7b" ,
			"3R1hBCHURkquAjFUv1eH5u2gXqooJkjg4B" ,
			"3DwVjwVeJa9Z5Pu15WHNfKcDxY5tFUGfdx" ,
			"3FrM1He2ZDbsSKmYpEZQNGjFTLMgCZZkaf" ,
			"1BZaYtmXka1y3Byi2yvXCDG92Tjz7ecwYj" ,
			"12xjTvg1aqK9Jc46N4cxTLiKnCWnDwD4S9" ,
			"1DWxysF7GPRYGShNxL5ux2N2JLRa9rbE6k" ,
			"1Cr7EjvS8C7gfarREHCvFhd9gT3r46pfLb" ,
			"17tC5SL95Lvj4CgDDqF1wWGeGUQcacq6Mc" ,
			"1KeK2uTAe8hDVKTbpyDDzd7qfRZ8z3LJx" ,
			"1HBM45n214sV9yXoizBwTksUgEysTPpk46" ,
			"12n3s8MCqdZzPnTisYrXagbfw8pJg8y9BW" ,
			"1MVo3EXLakJym29CFK6o1MyaCBMdvcmmrL" ,
			"14Ai5GcasUdr5hR2GMzeojkzB9cm4oufHt" ,
			"1FUBESNxB2JkyXPc4o9wwoGt158DC9A8dj" ,
			"16Azr3MAzMKMPmxZXfRsBbBPYHnp2CuJNJ" ,
			"1JpiTWauQdtysbynNp88dWeuyg2gBbKDcT" ,
			"1Q7cu7WkeDurYgffeEc9CEnA6zLohbh9iQ" ,
			"1EDRfeNkjkH2SAhSbEKzhKuabnEbVWbKEp" ,
			"1JYbzYitYQ1ZWTx5KEx7WH2AejC5i5UUbF" ,
			"1Enhkd9LkQV56a9M12P4VuMDkjyTeLJy5m" ,
			"1Cb1G5qFK91fShyaPPZWVFwYFBtqRG7h8D" ,
			"1Hyh53PULY6Jyq5LPAJ4CHjgzEbVaqy7KU" ,
			"1MqAfNMgbZoKtRinT89q1faSZqTKTqCFhR" ,
			"19Te6hzGFSbryomVYqzG2kpBmAJYykx5Yv" ,
			"14YN9Zsx4H8DXUoK2XfRvjuanfjK1RrkHz" ,
			"1NNGdZMYsN9pgLSXZ5dD5KFUbatFynpmvY" ,
			"1C5TB2QzeDDJUE4EQD17NmSyEXTk34huRo" ,
			"1C1bbDApniTd7DtUodpr3ayXxVtcHvwWgx" ,
			"1LyTftu54VMYCv5pq3S4pMzPRMnsYKTESw" ,
			"17YyZSNFt31pzGXfZtrzs7Y5Nd56rG2uU5" ,
			"1q9kwzJggw6AbQjzJeYQFYK8D5gQK8sSh" ,
			"153efDAfh8gUqGPH85JQXTrh8CQktAo9ug" ,
			"17rfparnM8RaaUyuHFNC9ErqkvRqebNPjE" ,
			"14zukxqLuLXg5kqZYRB1Q3Audec3NtxJPW" ,
			"19G5kkYvjawZiYKhFeh8WmfBN31pdP94Jr" ,
			"1Hm9vfrEX7Gyjz2Nhi3McQ34PryLDHGrCq" ,
			"1NDyJtNTjmwk5xPNhjgAMu4HDHigtobu1s" ,
			"1F34duy2eeMz5mSrvFepVzy7Y1rBsnAyWC" ,
			"3DVJfEsDTPkGDvqPCLC41X85L1B1DQWDyh" ,
			"3AWpzKtkHfWsiv9RGXKA3Z8951LefsUGXQ" ,
			"3FiMKffg2kY2Pi2Kebn2HZqN7m6kEcNUMk" ,
			"1f1miYFQWTzdLiCBxtHHnNiW7WAWPUccr" ,
			"3FuqMT3VeyRhB917aiJUeWSn2jRt4M3hw8" ,
			"3E5B5QbDjUL471PEed9vZDwCSck9btBLkD" ,
			"14YK4mzJGo5NKkNnmVJeuEAQftLt795Gec" ,
			"1KbrSKrT3GeEruTuuYYUSQ35JwKbrAWJYm" ,
			"12tLs9c9RsALt4ockxa1hB4iTCTSmxj2me" ,
			"1P1iThxBH542Gmk1kZNXyji4E4iwpvSbrt" ,
			"1BAFWQhH9pNkz3mZDQ1tWrtKkSHVCkc3fV"};

	
	public ResultModel btc()  {
		
		ResultModel result=new ResultModel();
		for (int i = 0; i < 1; i++) {
			try {
				String content=HttpUtils.httpContent(URL+BTC_ADDRESS[0]);
				Document doc = Jsoup.parse(content);
				Elements elements=doc.select("div.abstract-section");
				String address=elements.select("dl dd").first().text();
				String btcStr=elements.select("dl:eq(1) dd").first().text();
				String formatBtc=btcStr.replaceAll("BTC","").replaceAll(",","").replaceAll(" ","");
				System.out.println(address+" "+ formatBtc);
				BigDecimal number=new BigDecimal(formatBtc);
				result.addBtcs(address,number);

			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		BtcTotal btcTotal=new BtcTotal();
		ResultModel result=btcTotal.btc();
		System.out.println(result);
        
	}
}
