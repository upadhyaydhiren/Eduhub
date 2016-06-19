var app=angular.module("loginApp",['ui.bootstrap']);
app.service('categoryService', function()
{

		this.datas = [];
		this.data={};

		this.setDatas = function(datas) {
		 var temp = [];
		 angular.forEach(datas, function(data) {
			temp.push(data);
		 });
		 this.datas = temp;
		};

		this.getDatas = function() {
		 return this.datas;
		};

		this.getData = function() {
		 return this.data;
		};

		this.setData = function(data) {
		 this.data=data;
		};

		this.add = function(data) {
		 this.datas.push(data);
		};
		this.delete = function(index) {
		 this.datas.splice(index,1);
		};
		this.update = function(index, data) {
		 this.datas.splice(index, 1);
		 this.datas.splice(index, 0, data);
		};
		});
		app.service('collegeService', function()
		{

				this.datas = [];
				this.data={};

				this.setDatas = function(datas) {
				 var temp = [];
				 angular.forEach(datas, function(data) {
					temp.push(data);
				 });
				 this.datas = temp;
				};

				this.getDatas = function() {
				 return this.datas;
				};

				this.getData = function() {
				 return this.data;
				};

				this.setData = function(data) {
				 this.data=data;
				};

				this.add = function(data) {
				 this.datas.push(data);
				};
				this.delete = function(index) {
				 this.datas.splice(index,1);
				};
				this.update = function(index, data) {
				 this.datas.splice(index, 1);
				 this.datas.splice(index, 0, data);
				};
				});
			app.service('contributetrService', function()
			{

					this.datas = [];
					this.data={};

					this.setDatas = function(datas) {
					 var temp = [];
					 angular.forEach(datas, function(data) {
						temp.push(data);
					 });
					 this.datas = temp;
					};

					this.getDatas = function() {
					 return this.datas;
					};

					this.getData = function() {
					 return this.data;
					};

					this.setData = function(data) {
					 this.data=data;
					};

					this.add = function(data) {
					 this.datas.push(data);
					};
					this.delete = function(index) {
					 this.datas.splice(index,1);
					};
					this.update = function(index, data) {
					 this.datas.splice(index, 1);
					 this.datas.splice(index, 0, data);
					};
					});
app.service('userService', function()
{
		this.data = {}
		this.setData = function(data)
		{
			this.data = data;
		}
		this.getData = function(data)
		{
			return this.data;
		}
});
app.controller('loginController',function($scope,$http,$modal,categoryService,collegeService,contributetrService,userService){

$.scope.questionJSON = {
  "body": "string",
  "category": {
  },

  "isClosed": true,
  "title": "string",
  "topics": [
  ],
  "userId": {

  }
};
$.scope.answerJSON = {
  "answerText": "string",
  "question": {
  },
  "user": {
  }
};
$.scope.unAuthenticatedUserJSON =
{
  "email": "string",
  "fullName": "string",
	"password": "string"
};
$.scope.categoryJSON =[]
{
    "id": 0,
    "name": "string",
    "topics": [
      {
        
        "id": 0,
        "name": "string"
      }
    ]
  }];
	$scope.close = function() {
		$modalInstance.dismiss('close');
	};


	$scope.openModuleTemplate = function(url){
		var instance = $modal.open({
			templateUrl : url,
			backdrop : true,
			windowClass : 'modal',
			keyboard: true,
			controller:'loginController'
		});
	};

		$scope.getCategory = function()
		{
			var url;
			$http.get(url).success(function(response){
					
					categoryService.setDatas(response.data);
					$scope.categoryJSON=categoryService.getDatas();
			});
		}
		$scope.getColleges = function()
		{
				var url;
			$http.get(url).success(function(response){
					collegeService.setDatas(response.data);
			});
		}
		$scope.getAllContributer = function ()
		{
				var url;
			$http.get(url).success(function(response){
					contributetrService.setDatas(response.data);
			});
		}
		$scope.signUp = function ()
		{
			var url;
			$http.post(url,data).success(function(response)
			{
					if(response.status == 200)
					{
						$window.location.href = '';
					}
			});
		}
		$scope.login = function ()
		{
			var url;
			$http.post(url,data).success(function(response)
			{
					if(response.status == 200)
					{
						$window.location.href = '';
					}
			});
		}
		$scope.askQuestionPage = function()
		{

		}
		$scope.askQuestionPost = function()
		{
			var url;
			$.http.post(url,data).success(function(response)
			{
					if(response.status == 200)
					{
						$window.location.href = '';
					}
			});
		}
});
