function trending() {
	$
			.ajax({
				url : '/category',
				data : {
					format : 'json'
				},
				error : function(xhr) {
					console.log(xhr);
				},

				success : function(data) {
					$(data)
							.each(
									function(index) {
										var str = '<div class="thumbnailsetting"><a href class="thumbnail thumbnailtextcolor"> </br><center>'
												+ $(this)
												+ '</center></a></div>'
										$("#topics").append(str);
									});
				},
				type : 'GET'
			});
}