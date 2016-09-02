# contribution-analyzer
Trying to understand how one contributes to open source projects.


JSON数据解释：
repo-
repo_age ：项目存在的天数（判断一个项目的成熟程度）
repo_name：项目的名称
stargazers_count：项目的star数值（数值的大小衡量对这个项目感兴趣的群体的大小）


user-
  "test_inclusion" : 这个pullrequest是否包含 test 的pathname
  "followers" : user的粉丝数（表明user在群体中的地位）
  "pull_changed_files" : pullrequest的file changed的数目（根据数值大小判断这个pullrequest是否易读）
  "user_name" : 用户名称
  "following_user" : subimtter是否有关注关闭这个pullrequest的user（判断subimtter与user的亲密程度）
  "pull_comments" : pullrequest的comments数值（根据数值去衡量discussion的程度）
  "pull_commits" :  pullrequest的commits数值(根据数值大小衡量这个pullrequest的易读性)
