document.addEventListener("DOMContentLoaded", () => {

	// モーダル表示の関数
	function showModal(link) {
		const id = link.getAttribute('data-id'); // idを取得
		const modal = document.getElementById("deleteModal");
		modal.style.display = "flex";
		// 削除ボタンにIDを渡す
		document.querySelector(".confirm").onclick = () => confirmDelete(id);
	}

	function confirmDelete(id) {
		console.log("削除対象ID: ", id);  // idがnullでないか確認
		if (confirm(`ID: ${id} の企業情報を削除しますか？`)) {
			window.location.href = `/deleteCompany2?id=${id}`;
		}
	}
	// モーダルを閉じる
	document.getElementById("cancelDeleteButton").onclick = () => {
		document.getElementById("deleteModal").style.display = "none";
	};

});
