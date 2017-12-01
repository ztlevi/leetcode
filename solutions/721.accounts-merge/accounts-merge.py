class Solution:
    def accountsMerge(self, accounts):
        """
        :type accounts: List[List[str]]
        :rtype: List[List[str]]
        """
        
        visited_accounts = [False] * len(accounts)
        emails_accounts_map = collections.defaultdict(list) # email : [account_id]
        res = []
         
        # Build up the graph
        for i, account in enumerate(accounts):
            name = account[0]
            for j in range(1, len(account)):
                email = account[j]
                emails_accounts_map[email].append(i)
                
        # DFS
        def dfs(i, emails):
            if visited_accounts[i]:
                return
            visited_accounts[i] = True
            for j in range(1, len(accounts[i])):
                email = accounts[i][j]
                emails.add(email)
                for neighbour in emails_accounts_map[email]:
                    dfs(neighbour, emails)
        
        for i, account in enumerate(accounts):
            if visited_accounts[i]:
                continue
            name, emails = account[0], set()
            dfs(i, emails)
            res.append([name] + list(sorted(emails)))
        return res