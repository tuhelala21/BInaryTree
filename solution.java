//层序遍历

class Solution{
	public List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> list=new ArrayList<>();
		if(root==null){
			return list;
		}
		class NodeLevel{
			Node node;
			int level;

			NodeLevel(Node node,int level){
				this.node=node;
				this.level=level;
			}
		}
		LinkedList<NodeLevel> queue=new LinkedList<>();
		queue.addLast(new NodeLevel(root,0));
		while(!queue.isEmpty()){
			NodeLevel front =queue.pollFirst();
			Node node=front.node;
			int level=front.level;
			if(list.size()==level){
				list.add(new ArrayList<>());
			}
			list.get(level).add(node.val);
			if (node.left !=null){
				queue.addLast(new NodeLevel(node.left,level+1));
			}
			if (node.right!=null){
				queue.addLast(new NodeLevel(node.right,level+1));
			}

		}
		return list;
	}
}