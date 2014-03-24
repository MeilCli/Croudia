Croudia
=======

CroudiaのAPIを呼び出すjavaライブラリです  
このライブラリは非公式です、何かあれば([@meil_mitu][twitter])まで  
[twitter]: https://twitter.com/meil_mitu
またCroudiaはクローディア株式会社の登録商標です

連絡事項
--------

Entityオブジェクト未実装  
画像を扱うAPI未実装  
デバッグは必要最小限しか済ませていない  
gzip関連の操作は実現できていない

見ておくべきパッケージ
----------------------

info.re4k.asfc.croudia  
info.re4k.asfc.croudia.param

使い方
------

	Croudia croudia = new Croudia(new CroudiaConfig(ck,cs));
	croudia.getAuthorizeURL();//ここで認証用URLを取得
	//認証用URLでユーザーに認証させる
	croudia.getAccessToken(callback)//コールバックURLをgetAuthorizeURL()をしたインスタンスのに渡す
	//トークン保存

トークンの有効期限が切れてたら自動的にrefreshToken()してAPIを呼びなおします  
またトークンは常に最新値である必要があるのでAPIコール後常にトークンを保存するように  
400コードでinvalid_grantエラーが出たらリフレッシュトークンの有効期限が切れてるので再度認証しましょう

ライセンス
----------

This source is The MIT License.

Include Apache Commons Codec library [Apache License, Version 2.0][Apache]  
Include JSON library [JSON License][JSON]
[Apache]: http://www.apache.org/licenses/LICENSE-2.0
[JSON]: http://www.json.org/license.html