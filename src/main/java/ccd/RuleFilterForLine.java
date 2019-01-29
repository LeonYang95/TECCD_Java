package ccd;

import java.util.HashMap;
import java.util.Map;

//规则过滤
public class RuleFilterForLine {

    public static Map<Integer, String> ruleFilter(){
        Map<Integer, String> map = new HashMap<>();
        map.put(0,"literal");
        map.put(1,"type");
        map.put(2,"primitiveType");
        map.put(3,"numericType");
        map.put(4,"integralType");
        map.put(5,"floatingPointType");
        map.put(6,"referenceType");
        map.put(7,"classOrInterfaceType");
        map.put(8,"classType");
        map.put(9,"classType_lf_classOrInterfaceType");

        map.put(10,"classType_lfno_classOrInterfaceType");
        map.put(11,"interfaceType");
        map.put(12,"interfaceType_lf_classOrInterfaceType");
        map.put(13,"interfaceType_lfno_classOrInterfaceType");
        map.put(14,"typeVariable");
        map.put(15,"arrayType");
        map.put(16,"dims");
        map.put(17,"typeParameter");
        map.put(18,"typeParameterModifier");
        map.put(19,"typeBound");

        map.put(20,"additionalBound");
        map.put(21,"typeArguments");
        map.put(22,"typeArgumentList");
        map.put(23,"typeArgument");
        map.put(24,"wildcard");
        map.put(25,"wildcardBounds");
        map.put(26,"packageName");
        map.put(27,"typeName");
        map.put(28,"packageOrTypeName");
        map.put(29,"expressionName");

        map.put(30,"methodName");
        map.put(31,"ambiguousName");
        map.put(32,"compilationUnit");
        map.put(33,"packageDeclaration");
        map.put(34,"packageModifier");
        map.put(35,"importDeclaration");
        map.put(36,"singleTypeImportDeclaration");
        map.put(37,"typeImportOnDemandDeclaration");
        map.put(38,"singleStaticImportDeclaration");
        map.put(39,"staticImportOnDemandDeclaration");

        map.put(40,"typeDeclaration");
        map.put(41,"classDeclaration");
        map.put(42,"normalClassDeclaration");
        map.put(43,"classModifier");
        map.put(44,"typeParameters");
        map.put(45,"typeParameterList");
        map.put(46,"superclass");
        map.put(47,"superinterfaces");
        map.put(48,"interfaceTypeList");
        map.put(49,"classBody");

        map.put(50,"classBodyDeclaration");
        map.put(51,"classMemberDeclaration");
        map.put(52,"fieldDeclaration");
        map.put(53,"fieldModifier");
        map.put(54,"variableDeclaratorList");
        map.put(55,"variableDeclarator");
        map.put(56,"variableDeclaratorId");
        map.put(57,"variableInitializer");
//        map.put(58,"unannType");
//        map.put(59,"unannPrimitiveType");

//        map.put(60,"unannReferenceType");
//        map.put(61,"unannClassOrInterfaceType");
//        map.put(62,"unannClassType");
//        map.put(63,"unannClassType_lf_unannClassOrInterfaceType");
//        map.put(64,"unannClassType_lfno_unannClassOrInterfaceType");
//        map.put(65,"unannInterfaceType");
//        map.put(66,"unannInterfaceType_lf_unannClassOrInterfaceType");
//        map.put(67,"unannInterfaceType_lfno_unannClassOrInterfaceType");
//        map.put(68,"unannTypeVariable");
//        map.put(69,"unannArrayType");

        map.put(70,"methodDeclaration");
        map.put(71,"methodModifier");
        map.put(72,"methodHeader");
        map.put(73,"result");
        map.put(74,"methodDeclarator");
        map.put(75,"formalParameterList");
        map.put(76,"formalParameters");
        map.put(77,"formalParameter");
        map.put(78,"variableModifier");
        map.put(79,"lastFormalParameter");

        map.put(80,"receiverParameter");
        map.put(81,"throws_");
        map.put(82,"exceptionTypeList");
        map.put(83,"exceptionType");
        map.put(84,"methodBody");
        map.put(85,"instanceInitializer");
        map.put(86,"staticInitializer");
        map.put(87,"constructorDeclaration");
        map.put(88,"constructorModifier");
        map.put(89,"constructorDeclarator");

        map.put(90,"simpleTypeName");
        map.put(91,"constructorBody");
        map.put(92,"explicitConstructorInvocation");
        map.put(93,"enumDeclaration");
        map.put(94,"enumBody");
        map.put(95,"enumConstantList");
        map.put(96,"enumConstant");
        map.put(97,"enumConstantModifier");
        map.put(98,"enumBodyDeclarations");
        map.put(99,"interfaceDeclaration");

        map.put(100,"normalInterfaceDeclaration");
        map.put(101,"interfaceModifier");
        map.put(102,"extendsInterfaces");
        map.put(103,"interfaceBody");
        map.put(104,"interfaceMemberDeclaration");
        map.put(105,"constantDeclaration");
        map.put(106,"constantModifier");
        map.put(107,"interfaceMethodDeclaration");
        map.put(108,"interfaceMethodModifier");
//        map.put(109,"annotationTypeDeclaration");
//
//        map.put(110,"annotationTypeBody");
//        map.put(111,"annotationTypeMemberDeclaration");
//        map.put(112,"annotationTypeElementDeclaration");
//        map.put(113,"annotationTypeElementModifier");
//        map.put(114,"defaultValue");
//        map.put(115,"annotation");
//        map.put(116,"normalAnnotation");
        map.put(117,"elementValuePairList");
        map.put(118,"elementValuePair");
        map.put(119,"elementValue");

        map.put(120,"elementValueArrayInitializer");
        map.put(121,"elementValueList");
//        map.put(122,"markerAnnotation");
//        map.put(123,"singleElementAnnotation");
        map.put(124,"arrayInitializer");
        map.put(125,"variableInitializerList");
        map.put(126,"block");
        map.put(127,"blockStatements");
//        map.put(128,"blockStatement");
        map.put(129,"localVariableDeclarationStatement");

        map.put(130,"localVariableDeclaration");
//        map.put(131,"statement");
        map.put(132,"statementNoShortIf");
//        map.put(133,"statementWithoutTrailingSubstatement");
        map.put(134,"emptyStatement");
        map.put(135,"labeledStatement");
        map.put(136,"labeledStatementNoShortIf");
        map.put(137,"expressionStatement");
        map.put(138,"statementExpression");
        map.put(139,"ifThenStatement");

        map.put(140,"ifThenElseStatement");
        map.put(141,"ifThenElseStatementNoShortIf");
        map.put(142,"assertStatement");
        map.put(143,"switchStatement");
        map.put(144,"switchBlock");
        map.put(145,"switchBlockStatementGroup");
        map.put(146,"switchLabels");
        map.put(147,"switchLabel");
        map.put(148,"enumConstantName");
        map.put(149,"whileStatement");

        map.put(150,"whileStatementNoShortIf");
        map.put(151,"doStatement");
        map.put(152,"forStatement");
        map.put(153,"forStatementNoShortIf");
        map.put(154,"basicForStatement");
        map.put(155,"basicForStatementNoShortIf");
        map.put(156,"forInit");
        map.put(157,"forUpdate");
        map.put(158,"statementExpressionList");
        map.put(159,"enhancedForStatement");

        map.put(160,"enhancedForStatementNoShortIf");
        map.put(161,"breakStatement");
        map.put(162,"continueStatement");
        map.put(163,"returnStatement");
        map.put(164,"throwStatement");
        map.put(165,"synchronizedStatement");
        map.put(166,"tryStatement");
        map.put(167,"catches");
        map.put(168,"catchClause");
        map.put(169,"catchFormalParameter");

        map.put(170,"catchType");
        map.put(171,"finally_");
        map.put(172,"tryWithResourcesStatement");
        map.put(173,"resourceSpecification");
        map.put(174,"resourceList");
        map.put(175,"resource");
//        map.put(176,"primary");
//        map.put(177,"primaryNoNewArray");
//        map.put(178,"primaryNoNewArray_lf_arrayAccess");
//        map.put(179,"primaryNoNewArray_lfno_arrayAccess");

//        map.put(180,"primaryNoNewArray_lf_primary");
//        map.put(181,"primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary");
//        map.put(182,"primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary");
//        map.put(183,"primaryNoNewArray_lfno_primary");
//        map.put(184,"primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary");
//        map.put(185,"primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary");
//        map.put(186,"classInstanceCreationExpression");
//        map.put(187,"classInstanceCreationExpression_lf_primary");
//        map.put(188,"classInstanceCreationExpression_lfno_primary");
//        map.put(189,"typeArgumentsOrDiamond");

        map.put(190,"fieldAccess");
//        map.put(191,"fieldAccess_lf_primary");
//        map.put(192,"fieldAccess_lfno_primary");
//        map.put(193,"arrayAccess");
//        map.put(194,"arrayAccess_lf_primary");
//        map.put(195,"arrayAccess_lfno_primary");
        map.put(196,"methodInvocation");
        map.put(197,"methodInvocation_lf_primary");
        map.put(198,"methodInvocation_lfno_primary");
        map.put(199,"argumentList");

        map.put(200,"methodReference");
        map.put(201,"methodReference_lf_primary");
        map.put(202,"methodReference_lfno_primary");
        map.put(203,"arrayCreationExpression");
        map.put(204,"dimExprs");
        map.put(205,"dimExpr");
        map.put(206,"constantExpression");
        map.put(207,"expression");
//        map.put(208,"lambdaExpression");
//        map.put(209,"lambdaParameters");

//        map.put(210,"inferredFormalParameterList");
        map.put(211,"lambdaBody");
        map.put(212,"assignmentExpression");
        map.put(213,"assignment");
//        map.put(214,"leftHandSide");
//        map.put(215,"assignmentOperator");
//        map.put(216,"conditionalExpression");
//        map.put(217,"conditionalOrExpression");
//        map.put(218,"conditionalAndExpression");
//        map.put(219,"inclusiveOrExpression");

//        map.put(220,"exclusiveOrExpression");
//        map.put(221,"andExpression");
//        map.put(222,"equalityExpression");
//        map.put(223,"relationalExpression");
//        map.put(224,"shiftExpression");
//        map.put(225,"additiveExpression");
//        map.put(226,"multiplicativeExpression");
//        map.put(227,"unaryExpression");
//        map.put(228,"preIncrementExpression");
//        map.put(229,"preDecrementExpression");

//        map.put(230,"unaryExpressionNotPlusMinus");
        map.put(231,"postfixExpression");
        map.put(232,"postIncrementExpression");
        map.put(233,"postIncrementExpression_lf_postfixExpression");
        map.put(234,"postDecrementExpression");
        map.put(235,"postDecrementExpression_lf_postfixExpression");
        map.put(236,"castExpression");

        return map;
    }
}
