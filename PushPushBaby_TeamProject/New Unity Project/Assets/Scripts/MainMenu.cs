using UnityEngine;
using UnityEngine.UI;
using System.Collections;
using UnityEngine.SceneManagement;

public class MainMenu : MonoBehaviour {

	public Text scoreText;

	private void Start() {

		scoreText.text = PlayerPrefs.GetInt ("score").ToString ();
	}

	private void Update () {

		if (Application.platform == RuntimePlatform.Android) {

			if (Input.GetKey (KeyCode.Escape)) {

				Application.Quit ();
			}
		}
	}

	public void ToGame() {

		SceneManager.LoadScene ("Game");
	}

	public void ToRank() {

		SceneManager.LoadScene ("Rank");
	}
}
