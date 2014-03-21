package info.re4k.asfc.croudia;

public interface Trend{
	/**
	 * @return トレンドワード
	 */
	public String getName();

	/**
	 * @return トレンドワードを実際に検索する為に使うクエリ
	 */
	public String getQuery();

	/**
	 * @return スポンサー付きのトレンドワードかどうか 返り値がわからないのでとりあえずbooleanで対応
	 */
	public boolean isPromotedContent();
}
