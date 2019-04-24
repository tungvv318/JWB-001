<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="/css/main.css" rel="stylesheet">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<div ng-app="myApp" ng-controller="myController" class="container">
    <br/><br/>
    <div>
        <button class="btn btn-light" type="button" ng-click="toggleModalAdd()">Add User</button>
    </div>
    <br/><br/>

    <table border="1" class="table table-striped">
        <thead>
            <tr class="table-success">
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Balance</th>
                <th></th>
            </tr>
        </thead>

        <tbody>
            <tr ng-repeat="user in users">
                <th>{{user.id}}</th>
                <th>{{user.name}}</th>
                <th>{{user.email}}</th>
                <th>{{user.phone}}</th>
                <th>{{user.balance}}</th>
                <th><button class="btn btn-light" type="button">Edit</button></th>
            </tr>
        </tbody>
    </table>

    <modal title="Add user" visible="showModalAdd">
        <form role="form">
            <div class="form-group">
                <label>Enter ID</label>
                <input type="number" class="form-control" ng-model="newUser.id"/>
            </div>
            <div class="form-group">
                <label>Enter Name</label>
                <input type="text" class="form-control" ng-model="newUser.name"/>
            </div>
            <div class="form-group">
                <label>Enter Email</label>
                <input type="email" class="form-control" ng-model="newUser.email"/>
            </div>
            <div class="form-group">
                <label>Enter phone</label>
                <input type="tel" class="form-control" ng-model="newUser.phone"/>
            </div>
            <div class="form-group">
                <label>Enter balance</label>
                <input type="number" class="form-control" ng-model="newUser.balance"/>
            </div>

            <button type="button" class="btn btn-primary" ng-click="addUser()">Add</button>
        </form>
    </modal>
</div>

<script src="/js/main.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.1/angular.min.js"></script>
<script>
    var app = angular.module('myApp', []);
    app.controller('myController', function ($scope) {
        $scope.users = [
            {id:1, "id":"1", "name": "Nguyen Van A", "email": "abc@gmail.com", "phone": "0123456789", "balance": "100"},
            {id:2, "id":"2", "name": "Nguyen Van A", "email": "abc@gmail.com", "phone": "0123456789", "balance": "200"},
            {id:3, "id":"3", "name": "Nguyen Van A", "email": "abc@gmail.com", "phone": "0123456789", "balance": "300"},
            {id:4, "id":"4", "name": "Nguyen Van A", "email": "abc@gmail.com", "phone": "0123456789", "balance": "400"}
        ];

        $scope.newUser = {};
        $scope.addUser = function () {
            if($scope.newUser.id
               && $scope.newUser.name
               && $scope.newUser.email
               && $scope.newUser.phone
               && $scope.newUser.balance) {
                $scope.users.push({
                    "id": $scope.newUser.id,
                    "name": $scope.newUser.name,
                    "email": $scope.newUser.email,
                    "phone": $scope.newUser.phone,
                    "balance": $scope.newUser.balance
                });
                $scope.isAddForm = false;
            }
        };

        $scope.showModalAdd = false;
        $scope.toggleModalAdd = function () {
            $scope.showModalAdd = !$scope.showModalAdd;
        };
    });

    app.directive('modal', function () {
        return {
            template: '<div class="modal fade">' +
                '<div class="modal-dialog">' +
                '<div class="modal-content">' +
                '<div class="modal-header">' +
                '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>' +
                '<h4 class="modal-title">{{ title }}</h4>' +
                '</div>' +
                '<div class="modal-body" ng-transclude></div>' +
                '</div>' +
                '</div>' +
                '</div>',
            restrict: 'E',
            transclude: true,
            replace:true,
            scope:true,
            link: function postLink(scope, element, attrs) {
                scope.title = attrs.title;

                scope.$watch(attrs.visible, function(value){
                    if(value == true)
                        $(element).modal('show');
                    else
                        $(element).modal('hide');
                });

                $(element).on('shown.bs.modal', function(){
                    scope.$apply(function(){
                        scope.$parent[attrs.visible] = true;
                    });
                });

                $(element).on('hidden.bs.modal', function(){
                    scope.$apply(function(){
                        scope.$parent[attrs.visible] = false;
                    });
                });
            }
        };
    })
</script>
</body>
</html>