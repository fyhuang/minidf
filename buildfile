mdl = Layout.new
mdl[:source, :main, :java] = 'src'
mdl[:source, :main, :resources] = 'resources'

define 'minidf', :layout => mdl do
    project.version = '0.1.0'
    package :jar
end
