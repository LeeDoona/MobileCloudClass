using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class TestGUI : MonoBehaviour
{
	// Update is called once per frame
	void Update ()
	{
		if (Application.platform == RuntimePlatform.Android)
		{

			if (Input.GetKey(KeyCode.Escape))
			{
				Application.Quit();
				return;
			}
		}
	}

	void OnGUI()
	{
		GUI.Label(new Rect(0, 0, 100, 100), AndroidManager.GetInstance().strLog);

		if (GUI.Button (new Rect (0, 100, 100, 100), "TestButton") == true) {
			AndroidManager.GetInstance ().CallJavaFunc ("javaTestFunc", "UnityJavaJarTest");
		}
	}
}
