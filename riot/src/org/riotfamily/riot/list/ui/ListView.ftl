<#import "/spring.ftl" as spring />
<?xml version="1.0" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" 
		"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>${title?if_exists}</title>
		<link rel="stylesheet" href="${request.contextPath}${resourcePath}/style/list.css" type="text/css" />
		<#list customStyleSheets as item>
			<link rel="stylesheet" href="${request.contextPath}${resourcePath}/${item}" type="text/css" />
		</#list>
		<script type="text/javascript" language="JavaScript" src="${request.contextPath}${resourcePath}/prototype/prototype.js"></script>
		<script type="text/javascript" language="JavaScript" src="${request.contextPath}${resourcePath}/scriptaculous/effects.js"></script>
		<script type="text/javascript" language="JavaScript" src="${request.contextPath}${resourcePath}/riot-js/util.js"></script>
		<script type="text/javascript" language="JavaScript" src="${request.contextPath}${resourcePath}/riot-js/pager.js"></script>
		
		<script type="text/javascript" language="JavaScript" src="${request.contextPath}${resourcePath}/dwr/engine.js"></script>
		<script type="text/javascript" language="JavaScript" src="${request.contextPath}${resourcePath}/dwr/util.js"></script>
		<script type="text/javascript" language="JavaScript" src="${request.contextPath}${resourcePath}/dwr/interface/ListService.js"></script>
		<script type="text/javascript" language="JavaScript" src="${request.contextPath}${resourcePath}/list.js"></script>
		
		<script type="text/javascript" language="JavaScript" src="${request.contextPath}${resourcePath}/path.js"></script>		
		<script type="text/javascript" language="JavaScript" src="${request.contextPath}${resourcePath}/style/tweak.js"></script>		
		<script type="text/javascript" language="JavaScript">
			updatePath('${editorId}', null, '${parentId?if_exists}');
		</script>		
	</head>
	
	<#assign hasExtraColumn = hasCommands || filterForm?exists />
	
	<body onload="TweakStyle.list()"<#if !hasExtraColumn> class="wide"</#if>>
		<div id="wrapper">
			<div class="main">
				<div id="list"></div>
			</div>		
		</div>
		<div class="extra">
			
			<#if filterForm?exists>
				<div id="filter" class="box">
					<div class="title">
						<span><@spring.messageText "label.list.filter", "Filter" /></span>
					</div>
					<div id="filterForm">
					</div>
				</div>
			</#if>
			
			<#if hasCommands>
				<div id="commands" class="box">
					<div class="title">
						<span><@spring.messageText "label.commands", "Commands" /></span>
					</div>
					<div id="listCommands">
					</div>
				</div>
			</#if>
			
		</div>
		<script type="text/javascript" language="JavaScript">
			var list = new RiotList('${listKey}');
			list.render('list', 'listCommands'<#if filterForm?exists>, 'filterForm'</#if>);
		</script>
	</body>
</html>