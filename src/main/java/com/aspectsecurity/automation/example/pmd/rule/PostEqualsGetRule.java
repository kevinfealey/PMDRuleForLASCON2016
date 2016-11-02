package com.aspectsecurity.automation.example.pmd.rule;

import java.util.List;

import org.jaxen.JaxenException;

import net.sourceforge.pmd.lang.ast.AbstractNode;
import net.sourceforge.pmd.lang.java.ast.ASTMethodDeclaration;
import net.sourceforge.pmd.lang.java.ast.ASTMethodDeclarator;
import net.sourceforge.pmd.lang.java.ast.ASTName;
import net.sourceforge.pmd.lang.java.ast.ASTNormalAnnotation;
import net.sourceforge.pmd.lang.java.ast.ASTWhileStatement;
import net.sourceforge.pmd.lang.java.rule.AbstractJavaRule;

public class PostEqualsGetRule extends AbstractJavaRule {
	public Object visit(ASTMethodDeclaration node, Object data) {

		if (node.getFirstChildOfType(ASTMethodDeclarator.class).getImage().equals("doPost") || node.getFirstChildOfType(ASTMethodDeclarator.class).getImage().equals("doGet")) {
			try {
				List<AbstractNode> params = node
						.findChildNodesWithXPath("Block/BlockStatement/Statement/StatementExpression/PrimaryExpression/PrimarySuffix/Arguments/ArgumentList/Expression/PrimaryExpression/PrimaryPrefix/Name");
				if(params.size() > 0 ){
					if(params.get(0).getImage().equals("request") && params.get(1).getImage().equals("response")){
						addViolation(data, node);
					}
				}
			} catch (JaxenException e) {
				e.printStackTrace();
			}
		}
		return super.visit(node, data);
	}
}
