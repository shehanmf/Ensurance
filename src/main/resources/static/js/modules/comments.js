angular.module('commentlist', [])
  .controller('commentlistctrl', ['$scope', function($scope) {
    $scope.comments = [{
        user:{id:'1', username:'User 1'},
      title: 'Comment 1',
      comment: 'Comment',
        createdDate:'2015-12-01',
        rating:4
    },
    {
      user:{id:'2', username:'User 2'},
      title: 'Comment 2',
      comment: 'Comment 2',
        createdDate:'2015-12-02',
        rating:3
    }];
  }])
  .directive('commentList', function() {
    return {
      template: '<table>'+
      '<tr ng-repeat="comment in comments">'+
      '<td>{{comment.user.username}}'+
        '</td>'+
        '<td><table>'+
        '<tr>'+
        '<td><b>{{comment.title}}</b></td></tr>'+
        '<tr><td>{{comment.createdDate}}</td></tr>'+
        '<tr><td>{{comment.comment}}</td></tr>'+
        '</table>'+
        '</td>'+
      '</tr>'+
      '</table>'
    };
  });