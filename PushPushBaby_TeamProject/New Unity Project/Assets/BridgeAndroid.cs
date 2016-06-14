using UnityEngine;
using System.Collections;

public class BridgeAndroid : MonoBehaviour {
	private AndroidJavaObject curActivity;
	public string strLog = "No Java Log";
	static BridgeAndroid _instance;

	public static BridgeAndroid GetInstance()
	{
		if (_instance == null) {
			_instance = new GameObject ("BridgeAndroid").AddComponent<BridgeAndroid> ();
		}
		return _instance;
	}

	void Awake()
	{
		//현재 활성화 된 액티비티 얻어와서 저장
		AndroidJavaClass jc = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
		curActivity = jc.GetStatic<AndroidJavaObject> ("currentActivity");
	}

	// Use this for initialization
	void Start () {
	
	}

	public void CallJavaFunc(string strFuncName, string strTemp)
	{
		if (curActivity == null)
			return;

		curActivity.Call (strFuncName, strTemp);
	}

	void SetJavaLog(string strJavaLog)
	{
		strLog = strJavaLog;
	}
}
