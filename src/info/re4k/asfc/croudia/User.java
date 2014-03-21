package info.re4k.asfc.croudia;

public interface User{
	/**
	 * @return アカウント登録日時
	 */
	public long getCreatedAt();

	/**
	 * @return status数
	 */
	public int getStatusesCount();

	/**
	 * @return お気に入り数
	 */
	public int getFavoritesCount();

	/**
	 * @return フォロー数
	 */
	public int getFriendsCount();

	/**
	 * @return フォロワー数
	 */
	public int getFollowersCount();

	/**
	 * @return フォローリクエスト中かどうか
	 */
	public boolean isFollowRequestSent();

	/**
	 * @return フォロー中かどうか
	 */
	public boolean isFollowing();

	/**
	 * @return 非公開かどうか
	 */
	public boolean isProtected();

	/**
	 * @return ユーザーID
	 */
	public long getId();

	/**
	 * @return ユーザー名
	 */
	public String getName();

	/**
	 * @return スクリーンネーム
	 */
	public String getScreenName();

	/**
	 * @return 自己紹介文
	 */
	public String getDescription();

	/**
	 * @return 位置情報
	 */
	public String getLocation();

	/**
	 * @return URL
	 */
	public String getUrl();

	/**
	 * @return アイコンURL
	 */
	public String getProfileImageUrlHttps();

	/**
	 * @return カバー画像のURL
	 */
	public String getCoverImageUrlHttps();

}
