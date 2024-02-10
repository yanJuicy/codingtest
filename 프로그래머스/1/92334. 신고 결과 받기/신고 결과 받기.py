def solution(id_list, report, k):
    user_receive_mail_dic = {}
    for id in id_list:
        user_receive_mail_dic[id] = 0
    
    report_dic = {}
    for r in report:
        id, report_id = r.split()
        if report_id not in report_dic:
            report_dic[report_id] = []
        if id not in report_dic[report_id]:
            report_dic[report_id].append(id)
        
    for report_key in report_dic.keys():
        if len(report_dic[report_key]) >= k:
            for id in report_dic[report_key]:
                user_receive_mail_dic[id] += 1

    answer = list(user_receive_mail_dic.values())
    return answer